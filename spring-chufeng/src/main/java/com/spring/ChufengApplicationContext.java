package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: chufeng Chen
 * @Description:手写spring容器
 * @Date:Create：in 2021/4/27 22:23
 */
public class ChufengApplicationContext {
    private Class configClass;
    private ConcurrentHashMap<String,Object> singletonObjects=new ConcurrentHashMap<>(); //单例池,一级缓存
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap =new ConcurrentHashMap<>();

    public ChufengApplicationContext(Class configClass) {
        this.configClass = configClass;
        //ComponentScan注解---->扫描路径---->扫描--->BeanDefinition---->BeanDefinitionMap
        Scan(configClass);

        for (Map.Entry<String,BeanDefinition> entry: beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if(beanDefinition.getScope().equals("singleton")){
                Object bean = createBean(beanDefinition);  //单例Bean
                singletonObjects.put(beanName,bean);
            }
        }
    }


    public Object createBean(BeanDefinition beanDefinition){  //根据BeanDefinition创建Bean的对象
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            //依赖注入
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)){  //加了Autowored注解的属性才回去赋值
                    Object bean = getBean(field.getName());
                    field.set(instance,bean);
                }
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    private void Scan(Class configClass) {
        //解析配置类

        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();
//        path=path.replace(".","/");
        System.out.println("ComponentScan注解的扫描路径:"+path);
        //扫描path路径下的类找出来，判断类上面是否有加Component注解
        //根据包名，得到包下所有的类,先要通过类加载器把class文件加载到JVM内存中
        //Bootstrap --->jre/lib
        //Ext ---->jre/ext/lib
        //App ---->classpath
        ClassLoader classLoader = ChufengApplicationContext.class.getClassLoader();//app类加载器
        //通过类加载器拿类的资源信息
        URL resource = classLoader.getResource("com/service") ;//是app类加载器的路径：classpath=D:\document\core-knowledge\spring-chufeng\target\classes
        //得到的resource是一个目录,把resource转成一个file对象
        File file = new File(resource.getFile());
        if(file.isDirectory()){
            File[] files = file.listFiles();//把这个目录下的文件拿出来
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")){  //是类文件才进行处理
                    System.out.println(fileName);
                    String className=fileName.substring(fileName.indexOf("com"),fileName.indexOf(".class"));
                    System.out.println(className);
                    className=className.replace("\\",".");  //获得要加载类的全限定类名
                    System.out.println(className);
                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if(clazz.isAnnotationPresent(Component.class)){
                            //当前这个类是一个Bean
                            //解析类--->BeanDefinition，判断当前Bean是单例Bean还是原型Bean
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            //获取当前Bean的名字
                            String beanName = componentAnnotation.value();
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            if(clazz.isAnnotationPresent(Scope.class)){
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            }else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName,beanDefinition);

                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public Object getBean(String beanName){
        if (beanDefinitionMap.containsKey(beanName)){ //如果有，表示当前spring容器有这个Bean
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName); //拿到这个Bean的对象
            //判断这个Bean是单例的还是原型的
            if(beanDefinition.getScope().equals("singleton")){
                Object o = singletonObjects.get(beanName);//从单例池里面拿到这个Bean对象
                return o;
            }else{
                //创建Bean对象
                Object bean = createBean(beanDefinition);
                return bean;
            }
        }else { //不存在对应的Bean
            throw new NullPointerException();
        }
    }
}

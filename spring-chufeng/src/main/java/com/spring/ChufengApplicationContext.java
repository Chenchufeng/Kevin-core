package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @Author: chufeng Chen
 * @Description:手写spring容器
 * @Date:Create：in 2021/4/27 22:23
 */
public class ChufengApplicationContext {
    private Class configClass;

    public ChufengApplicationContext(Class configClass) {
        this.configClass = configClass;

        //解析配置类
        //ComponentScan注解---->扫描路径---->扫描
        ComponentScan componentScanAnnotation = (ComponentScan)configClass.getDeclaredAnnotation(ComponentScan.class);
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
        URL resource = classLoader.getResource("com/service");//是app类加载器的路径：classpath=D:\document\core-knowledge\spring-chufeng\target\classes
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
                            System.out.println(className+"这个类带有Component注解");
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public Object getBean(String beanName){
        return null;
    }
}

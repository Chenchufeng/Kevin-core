import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/25 23:36
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //使用自定义类加载器
        ClassLoader myCL = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException{
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";

                    // /开头代表从项目的ClassPath根下获取资源
//                    InputStream is = getClass().getResourceAsStream("/classloader/" +fileName);

                    // 不以'/'开头时，默认是指所在类的相对路径
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return  super.loadClass(name);
                    }

                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return  defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return super.loadClass(name);
            }
        };

        //获取加载类的一个对象
        Object instance = null;
        try {
            instance = myCL.loadClass("classloader.ClassLoaderTest").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //返回instance对象运行时属于哪个类
        System.out.println(instance.getClass());

        //测试一个对象是否为一个类的实例
//        System.out.println(instance instanceof Classloader.ClassLoaderTest);
    }
}

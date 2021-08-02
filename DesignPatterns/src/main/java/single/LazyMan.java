package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Kevin
 * @Date: 2021/8/2 21:38
 * @Description: 懒汉式单例
 */
public class LazyMan {
    private LazyMan(){
        synchronized (LazyMan.class){
            if (lazyMan!=null){
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
//        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan = new LazyMan(); //不是原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        for (int i = 1; i <=10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
        //使用反射破坏单例：把私有的空参构造方法设置为可访问的
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> constructor = LazyMan.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan instance1 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
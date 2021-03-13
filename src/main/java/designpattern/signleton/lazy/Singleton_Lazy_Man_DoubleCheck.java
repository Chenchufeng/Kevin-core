package designpattern.signleton.lazy;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/13 21:06
 */
public class Singleton_Lazy_Man_DoubleCheck {
    private Singleton_Lazy_Man_DoubleCheck(){}

    private static volatile Singleton_Lazy_Man_DoubleCheck singleton;

    /**
     * 加入双重检查代码，保证了线程安全的问题，同时解决懒加载问题
     * 同时保证了效率，推荐使用
     * @return
     */
    public static Singleton_Lazy_Man_DoubleCheck getSingleton(){
        if (singleton==null){
            synchronized (Singleton_Lazy_Man_DoubleCheck.class){
                if (singleton==null){
                    singleton=new Singleton_Lazy_Man_DoubleCheck();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("双重检查，线程安全~");
        Singleton_Lazy_Man_DoubleCheck singleton2 = Singleton_Lazy_Man_DoubleCheck.getSingleton();
        Singleton_Lazy_Man_DoubleCheck singleton1 = Singleton_Lazy_Man_DoubleCheck.getSingleton();
        System.out.println(singleton1==singleton2);
        System.out.println("singleton1.hashCode= "+singleton1.hashCode());
        System.out.println("singleton2.hashCode= "+singleton2.hashCode());
    }
}

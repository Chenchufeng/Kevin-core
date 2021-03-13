package designpattern.signleton.lazy;

/**
 * @Author: chufeng Chen
 * @Description:  懒汉式单例
 * @Date:Create：in 2021/3/13 20:16
 */
public class Singleton_Lazy_Man {
    private Singleton_Lazy_Man(){ }
    private static Singleton_Lazy_Man singleton;

    /**
     * 如果在多线程下，当执行到singleton==null时，还未来得及往下执行，另外一个线程也通过了这个判断语句
     * 这时便会产生多个实例，所以在多线程环境下不可使用这种方式
     * 结论：实际开发中，不使用这种方式
     * @return
     */
    public static Singleton_Lazy_Man getSingleton(){
        // 被动创建，在真正需要使用时才去创建
        if (singleton==null){
            singleton= new Singleton_Lazy_Man();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("懒汉式1，线程不安全");
        Singleton_Lazy_Man singleton2 = Singleton_Lazy_Man.getSingleton();
        Singleton_Lazy_Man singleton1 = Singleton_Lazy_Man.getSingleton();
        System.out.println(singleton1==singleton2);
        System.out.println("singleton1.hashCode= "+singleton1.hashCode());
        System.out.println("singleton2.hashCode= "+singleton2.hashCode());
    }
}

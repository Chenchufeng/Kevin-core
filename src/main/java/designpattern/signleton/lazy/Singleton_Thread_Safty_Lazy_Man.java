package designpattern.signleton.lazy;

/**
 * @Author: chufeng Chen
 * @Description: 线程安全的懒汉式单例
 * @Date:Create：in 2021/3/13 20:25
 */
public class Singleton_Thread_Safty_Lazy_Man {

    private Singleton_Thread_Safty_Lazy_Man(){ }

    private static Singleton_Thread_Safty_Lazy_Man singleton;


    /**
     * 效率太低了，每个线程在想要获得类的实例的时候，执行getSingleton方法都要进行同步，而
     * 其实这个方法只执行一次代码实例化就够了，后面的想要获得该类实例直接return就行了
     * 方法进行同步效率太低
     * 结论：在实际开发中，不推荐使用这种方式
     * @return
     */
    // 使用synchronized修饰，临界资源的同步互斥访问
    public static synchronized Singleton_Thread_Safty_Lazy_Man getSingleton(){
        if (singleton==null){
            singleton=new Singleton_Thread_Safty_Lazy_Man();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("懒汉式2，线程安全~");
        Singleton_Thread_Safty_Lazy_Man singleton2 = Singleton_Thread_Safty_Lazy_Man.getSingleton();
        Singleton_Thread_Safty_Lazy_Man singleton1 = Singleton_Thread_Safty_Lazy_Man.getSingleton();
        System.out.println(singleton1==singleton2);
        System.out.println("singleton1.hashCode= "+singleton1.hashCode());
        System.out.println("singleton2.hashCode= "+singleton2.hashCode());
    }
}

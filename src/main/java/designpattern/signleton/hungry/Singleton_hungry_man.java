package designpattern.signleton.hungry;

/**
 * @Author: chufeng Chen
 * @Description: 饿汉 类加载的时候就创建了实例
 * 优点：类加载的时候创建一次实例，避免了多线程同步问题
 * 缺点：即使单例没被用到也会创建，浪费内存
 *
 * 静态变量和静态代码块的加载顺序由编写先后决定
 * @Date:Create：in 2021/3/13 20:09
 */
public class Singleton_hungry_man {
    //指向自己实例的静态私有引用，主动创建
    private static Singleton_hungry_man singleton=new Singleton_hungry_man();

    //私有构造方法
    private Singleton_hungry_man() {
    }

    //以自己实例为返回值的静态的公有方法，静态工厂方法
    public static Singleton_hungry_man getSingleton(){
        return singleton;
    }

}

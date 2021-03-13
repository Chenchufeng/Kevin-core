package designpattern.signleton.lazy;

/**
 * @Author: chufeng Chen
 * @Description: 静态内部类
 * @Date:Create：in 2021/3/13 21:21
 */
public class Singleton_InnerClass {
    //构造器私有化
    private Singleton_InnerClass(){}

    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance{
        private static final Singleton_InnerClass INSTANCE=new Singleton_InnerClass();
    }

    public static synchronized Singleton_InnerClass getInstance(){
        return SingletonInstance.INSTANCE;
    }








    public static void main(String[] args) {
        System.out.println("使用静态内部类完成代理模式~");
        Singleton_InnerClass singleton2 = Singleton_InnerClass.getInstance();
        Singleton_InnerClass singleton1 = Singleton_InnerClass.getInstance();
        System.out.println(singleton1==singleton2);
        System.out.println("singleton1.hashCode= "+singleton1.hashCode());
        System.out.println("singleton2.hashCode= "+singleton2.hashCode());
    }
}

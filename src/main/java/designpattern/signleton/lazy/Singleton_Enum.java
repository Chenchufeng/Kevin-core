package designpattern.signleton.lazy;

/**
 * @Author: chufeng Chen
 * @Description: 使用枚举实现单例模式，推荐
 * @Date:Create：in 2021/3/13 21:41
 */
public class Singleton_Enum {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1==instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        instance1.isOk();
    }
}

/**
 * 使用枚举实现单例模式，不仅能够避免多线程同步的问题，而且还能防止反序列化重新创建新的对象
 * 结论：推荐使用
 */
enum Singleton{
    INSTANCE; //属性
    public void isOk(){
        System.out.println("ok~");
    }
}

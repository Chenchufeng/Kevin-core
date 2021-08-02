package single;

/**
 * @Author: Kevin
 * @Date: 2021/8/2 21:32
 * @Description: 饿汉式单例
 * 私有的构造方法无法在本类外部使用，也就导致本类无法用new实例化，这样可以控制对象的生成。
 */
public class Hungry {
    private static Hungry hungry=new Hungry();
    private Hungry() {
    }

    public Hungry getInstance(){
        return hungry;
    }

}
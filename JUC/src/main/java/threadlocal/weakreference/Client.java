package threadlocal.weakreference;

/**
 * @Author: Kevin
 * @Date: 2021/8/24 23:40
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Salad salad=new Salad(new Apple("香蕉"));
        //通过WeakReference的get()方法获取Apple
        System.out.println("Apple:" + salad.get());
        System.gc();
        try {
            //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //如果为空，代表被回收了
        if (salad.get() == null) {
            System.out.println("clear Apple");
        }
    }
}
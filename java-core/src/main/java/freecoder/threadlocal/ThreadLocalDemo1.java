package freecoder.threadlocal;

/**
 * @Author: Kevin
 * @Date: 2021/11/26 21:35
 * @Description:
 */
public class ThreadLocalDemo1 {
    public static ThreadLocal threadLocal=new ThreadLocal();

    public static void main(String[] args) {
        Thread t1= new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set(0);
            System.out.println(threadLocal.get());
        });
        Thread t2= new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set(1);
            System.out.println(threadLocal.get());
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
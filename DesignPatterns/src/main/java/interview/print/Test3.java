package interview.print;

/**
 * @Author: Kevin
 * @Date: 2021/8/7 18:40
 * @Description:  两个线程替打印 1 - 100
 */
public class Test3 {
    private static Object lock = new Object();
    private static volatile int num = 0;

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (num < 100){
                        System.out.println(Thread.currentThread().getName() + "打印：" + ++num);
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        new Thread(runnable,"thread1").start();
        new Thread(runnable,"thread2").start();
    }

}
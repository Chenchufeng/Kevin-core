package interview.print;

/**
 * @Author: Kevin
 * @Date: 2021/8/7 19:54
 * @Description:  要求线程a执行完才开始线程b, 线程b执行完才开始线程
 */
public class T1T2T3 {
    public static class PrintThread extends Thread{
        PrintThread(String name){
            super(name);
        }
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }

    }

    public static void main(String[] args) {
        PrintThread t1 = new PrintThread("a");
        PrintThread t2 = new PrintThread("b");
        PrintThread t3 = new PrintThread("c");

        try {
            //join()方法的底层是利用wait()方法实现的。可以看出，join方法是一个同步方法，
            // 当主线程调用t1.join()方法时，主线程先获得了t1对象的锁，随后进入方法，调用了t1对象的wait()方法，
            // 使主线程进入了t1对象的等待池，此时，A线程则还在执行，并且随后的t2.start()还没被执行，因此，B线程也还没开始。
            // 等到A线程执行完毕之后，主线程继续执行，走到了t2.start()，B线程才会开始执行。
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
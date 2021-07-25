package add;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: Kevin
 * @Date: 2021/7/24 14:21
 * @Description: 单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了“锁”，再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。
 */
public class SemaphoreDemo2 {
    public static void main(String[] args) {
        final Business business = new Business();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        business.service();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }

    private static class Business {
        private int count;
        Semaphore sp = new Semaphore(1);

        public void service() throws InterruptedException {
            try {
                sp.acquire();  //当前线程使用count变量的时候将其锁住，不允许其他线程访问
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(count);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            } finally {
                sp.release();
            }
        }
    }
}
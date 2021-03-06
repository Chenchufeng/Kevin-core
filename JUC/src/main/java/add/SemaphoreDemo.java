package add;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Kevin
 * @Date: 2021/7/24 13:42
 * @Description: Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数，并发限流，保证服务器资源的高可用
 * 例如，实现一个文件允许的并发访问数。
 * Semaphore的主要方法摘要：
 *
 * 　　void acquire():从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
 *
 * 　　void release():释放一个许可，将其返回给信号量。
 *
 * 　　int availablePermits():返回此信号量中当前可用的许可数。
 *
 * 　　boolean hasQueuedThreads():查询是否有线程正在等待获取。
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        //对于引用变量被final修饰了:引用变量引用不可变，但是引用对象的内容可以改变。
        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();   ///请求获得许可，如果有可获得的许可则继续往下执行，许可数减1。否则进入阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "即将离开");
                    sp.release();//释放许可，许可数加1
                    //下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
                }
            };
            service.execute(runnable);
        }
    }
}
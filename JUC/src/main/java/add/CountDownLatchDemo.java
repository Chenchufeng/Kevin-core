package add;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Kevin
 * @Date: 2021/7/22 23:13
 * @Description: countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
 */
public class CountDownLatchDemo {
    /**
     * //构造方法,初始化一个CountDownLatch实例,指定计数count,一般指定为多线程的数量
     * public CountDownLatch(int count);
     * //阻塞线程,等待所有线程执行完成释放,继续执行后续代码
     * public void await() throws InterruptedException;
     * //阻塞线程,指定阻塞时间,阻塞时间超过后,无论所有线程是否执行完毕,都将继续执行后续代码
     * public boolean await(long timeout, TimeUnit unit) throws InterruptedException;
     * //计数器减1
     * public void countDown();
     * //获取当前计数器的值
     * public long getCount();
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+ " Go Out");
                countDownLatch.countDown(); //数量-1
            },String.valueOf(i)).start();
        }
        //每次线程调用countDown数量-1，假设计数器变为零，countDownLatch.await()就会被唤醒，继续执行
        countDownLatch.await(); //等待计数器归零，然后再向下执行
        System.out.println("CLose door");
    }
}
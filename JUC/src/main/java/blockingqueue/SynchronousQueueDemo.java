package blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Kevin
 * @Date: 2021/7/25 16:26
 * @Description: 没有容量，进去一个元素，必须等待取出来之后，才能再往里面放一个元素！
 * 同步队列
 * 和其他的BlockingQueue 不一样，
 * SynchronousQueue 不存储元素
 * put了一个元素，必须从里面先take取出来，否则不能在put进去值！
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+" put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+" put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>"+synchronousQueue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
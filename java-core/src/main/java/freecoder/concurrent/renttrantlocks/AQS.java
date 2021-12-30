package freecoder.concurrent.renttrantlocks;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Kevin
 * @Date: 2021/12/20 21:24
 * @Description:
 */
public class AQS {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        HashMap<Integer, String> hashMap = new HashMap<>();
//        test1();
        try {
            test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 场景一 线程1拿到锁，线程2尝试拿锁。
     */
    public static void test1(){
        Lock l=new ReentrantLock();
        Thread t1=new Thread(()->{
            l.lock();
            System.out.println("线程" + Thread.currentThread().getName() +"拿到锁");
            try {
                Thread.sleep(100000000000000000l);
            } catch (InterruptedException e) {
                System.out.println("线程" + Thread.currentThread().getName() +"释放锁");
            }
            l.unlock();
        },"t1");
        t1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        new Thread(()->{
           l.lock();
            System.out.println("线程" + Thread.currentThread().getName() +"拿到锁");
           l.unlock();
        },"t2").start();
        scanner.nextLine();
        t1.interrupt();//t1线程被被中断
    }

    public static void test2() throws InterruptedException {
        Lock l = new ReentrantLock();
        new Thread(()->{
            l.lock();
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.unlock();
        }).start();
        for(int i=0;i<100;i++){
            int t = i;
            new Thread(()->{
                l.lock();
                System.out.println(t);
                l.unlock();
            }).start();
            Thread.sleep(10);
        }
    }
}
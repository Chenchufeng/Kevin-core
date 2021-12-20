package freecoder.concurrent.synchronizeds;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Kevin
 * @Date: 2021/12/20 00:13
 * @Description:
 */
public class Concurrent3 {
    static Object object=new Object();
    static Lock lock=new ReentrantLock();
    static Condition c1=lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            test1();
        }
        Thread.sleep(2000);
        synchronized (object){
            object.notifyAll();
        }
//        lock.lock();
//        c1.signalAll();
//        lock.unlock();

    }
    public static void test1() throws InterruptedException {
        Thread t1=new Thread(()->{
           synchronized (object){
               try {
                   object.wait();
                   System.out.println("Hello");
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println(123);
                   e.printStackTrace();
               }
           }
        });
        t1.start();
        t1.join();
        t1.interrupt();
    }

    public static void test2(){
        Thread t2=new Thread(()->{
            try {
                lock.lock();
                c1.await();
                System.out.println("Hello");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        });
        t2.start();
    }
}
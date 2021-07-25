package ReetrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Kevin
 * @Date: 2021/7/24 14:55
 * @Description:
 * 什么是可重入锁，不可重入锁呢？"重入"字面意思已经很明显了，就是可以重新进入。
 * 可重入锁，就是说一个线程在获取某个锁后，还可以继续获取该锁，即允许一个线程多次获取同一个锁。
 * 比如synchronized内置锁就是可重入的，如果A类有2个synchornized方法method1和method2，那么method1调用method2是允许的。
 * 显然重入锁给编程带来了极大的方便。假如内置锁不是可重入的，那么导致的问题是：1个类的synchornized方法不能调用本类其他synchornized方法，
 * 也不能调用父类中的synchornized方法。与内置锁对应，JDK提供的显示锁ReentrantLock也是可以重入的。
 *
 * Summary:
    1.Java并发库中ReetrantReadWriteLock实现了ReadWriteLock接口并添加了可重入的特性
    2.ReetrantReadWriteLock读写锁的效率明显高于synchronized关键字
    3.ReetrantReadWriteLock读写锁的实现中，读锁使用共享模式；写锁使用独占模式，换句话说，读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的
    4.ReetrantReadWriteLock读写锁的实现中，需要注意的，当有读锁时，写锁就不能获得；而当有写锁时，除了获得写锁的这个线程可以获得读锁外，其他线程不能获得读锁

 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("Thread real execute");
                lock.writeLock().unlock();
            }
        });
        lock.writeLock().lock();
        lock.writeLock().lock();
        t.start();
        Thread.sleep(1000);
        System.out.println("release one once");
        lock.writeLock().unlock();
    }

}
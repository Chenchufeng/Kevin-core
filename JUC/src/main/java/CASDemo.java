import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Kevin
 * @Date: 2021/8/2 22:34
 * @Description:
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        //public final boolean compareAndSet(int expect, int update)
        //期望，更新
        //如果我们期望的值达到了，那么就更新，否则就不更新
        //==========捣乱的线程=============
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        //==========期望的线程=============
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());

    }
}
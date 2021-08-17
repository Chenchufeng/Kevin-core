package interview.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Kevin
 * @Date: 2021/8/8 13:48
 * @Description:
 * ThreadLocal的原理是操作Thread内部的一个ThreadLocalMap，这个Map的Entry继承了WeakReference,
 * 设值完成后map中是(WeakReference,value)这样的数据结构。java中的弱引用在内存不足的时候会被回收掉，回收之后变成(null,value)的形式，key被收回掉了。
 * 如果线程执行完之后销毁，value也会被回收,这样也没问题。但如果是在线程池中，线程执行完后不被回收，而是返回线程池中，
 * Thread有个强引用指向ThreadLocalMap,ThreadLocalMap有强引用指向Entry,导致value无法被回收，一直存在内存中。
 * 在执行了ThreadLocal.set()方法之后一定要记得使用ThreadLocal.remove(),将不要的数据移除掉，避免内存泄漏。
 * 通过分析源码，java也做了一定优化，即使出现了上诉的(null,value)情况，再调用一次ThreadLocal.set()也可以将这个废弃的替代调用

 */
public class ThreadNotSafeDemo {
    private static ExecutorService threadPool= Executors.newFixedThreadPool(16);
//    static SimpleDateFormat dateFormat= new SimpleDateFormat("mm:ss");
//通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。而使用ThreadLocal创建的变量只能被当前线程访问，其他线程则无法访问和修改。
    public String date(int seconds){
        Date date=new Date(1000*seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI=i;
            threadPool.submit(()->{
                try {
                    String date=new ThreadNotSafeDemo().date(finalI);
                    System.out.println(date);
                } finally {
                    //ThreadLocal被回收,key的值变成null,则导致整个value再也无法被访问到，因此依然存在内存泄漏。所以必须调用remove方法。
                    ThreadSafeFormatter.dateFormatThreadLocal.remove();
                }
            });
        }
        threadPool.shutdown();

    }
}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal=ThreadLocal.withInitial(()-> new SimpleDateFormat("mm:ss"));
}
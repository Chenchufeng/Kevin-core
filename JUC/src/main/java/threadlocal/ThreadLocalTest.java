package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Kevin
 * @Date: 2021/8/23 23:34
 * @Description:
 */
public class ThreadLocalTest {
    private static final AtomicInteger nextId=new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId =new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return nextId.getAndIncrement();
        }
    };

    public static int get(){
        Integer val = threadId.get();
        return val;
    }

    public static void remove(){
        threadId.remove();
    }

    private static void incrementSameThreadId(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"_"+",threadId "+threadId.get());
            }
        } finally {
            threadId.remove();
        }
    }

    public static void main(String[] args) {
        incrementSameThreadId();
        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();
    }
}
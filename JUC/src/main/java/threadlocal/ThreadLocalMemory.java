package threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kevin
 * @Date: 2021/8/24 21:57
 * @Description:
 */
public class ThreadLocalMemory {
    // Thread local variable containing each thread's ID
    public static ThreadLocal<List<Object>> threadId=new InheritableThreadLocal<List<Object>>(){
        protected List<Object> initialValue(){
            List<Object> list=new ArrayList<Object>();
            for (int i = 0; i < 10000; i++) {
                list.add(String.valueOf(i));
            }
            return list;
        }
    };
    // Returns the current thread's unique ID, assigning it if necessary
    public List<Object> get(){
        return threadId.get();
    }

    // remove currentid
    public void remove(){
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
        //  为了复现key被回收的场景，我们使用临时变量
        ThreadLocalMemory memory = new ThreadLocalMemory();
        incrementSameThreadId();
        System.out.println("GC前：key:" + memory.threadId);
//        System.out.println("GC前：value-size:" + refelectThreadLocals(Thread.currentThread()));

        // 设置为null，调用gc并不一定触发垃圾回收，但是可以通过java提供的一些工具进行手工触发gc回收。
        memory.threadId = null;
        System.gc();

        System.out.println("GC后：key:" + memory.threadId);
//        System.out.println("GC后：value-size:" + refelectThreadLocals(Thread.currentThread()));


        // 模拟线程一直运行
        while (true) {
        }
    }
}
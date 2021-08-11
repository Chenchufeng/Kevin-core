package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author: Kevin
 * @Date: 2021/8/1 16:44
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();  //sum=50000005000000 时间：110
        //test2();  //sum=50000005000000 时间：212
        test3();    //sum=50000005000000时间：237
    }

    // 普通程序员
    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_00; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    // 会使用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_00L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);// 提交任务
        Long sum=submit.get();
        long end =System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

    //高级处理
    public static void test3(){
        long start=System.currentTimeMillis();
        // Stream并行流 () (]
        long sum= LongStream.rangeClosed(0L,10_0000_00L).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" +sum+"时间："+(end-start));
    }

}
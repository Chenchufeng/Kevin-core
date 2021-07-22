package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Kevin
 * @Date: 2021/7/22 22:10
 * @Description:
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask继承了Runnable接口
        //new Thread(new FutureTask(new MyThread()),"A").start();
        MyThread myThread=new MyThread();
        FutureTask myFutureTask=new FutureTask(myThread);
        new Thread(myFutureTask,"A").start();
        new Thread(myFutureTask,"B").start(); //结果会被缓存，效率高
        String o = (String) myFutureTask.get();//获取callable的返回结果,这个方法可能会产生阻塞！
        System.out.println(o);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Kevin");
        //耗时的操作
        return "123";
    }
}
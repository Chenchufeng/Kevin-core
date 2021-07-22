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
        String o = (String) myFutureTask.get();//获取callable的返回结果
        System.out.println(o);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Kevin");
        return "123";
    }
}
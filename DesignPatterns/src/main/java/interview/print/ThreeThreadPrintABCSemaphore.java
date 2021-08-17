package interview.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: Kevin
 * @Date: 2021/8/7 20:26
 * @Description: 有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C，要求, 同时启动三个线程, 按顺序输出ABC, 循环10次。
 */
public class ThreeThreadPrintABCSemaphore {
    private static Semaphore as =new Semaphore(1);
    private static Semaphore bs =new Semaphore(0);
    private static Semaphore cs =new Semaphore(0);

    private static volatile int count=0;

    public static void main(String[] args) {
        System.out.println("Hello world");
        ExecutorService executor=Executors.newFixedThreadPool(3);
        executor.execute(new PrintA());
        executor.execute(new PrintB());
        executor.execute(new PrintC());
    }


    private static class PrintA implements Runnable{

        @Override
        public void run() {
            while(true){
                try{
                    //申请打印A许可
                    as.acquire();
                    if(count == 10){
                        bs.release();
                        break;
                    }
                    System.out.print("A");
                }catch(InterruptedException ex){

                }finally{
                    //A打印过之后发放一个打印B许可
                    bs.release();
                }
            }
        }
    }


    private static class PrintB implements Runnable
    {
        public void run(){
            while(true){
                try{
                    //申请打印B许可
                    bs.acquire();
                    //打印10次完成，结束
                    if(count == 10){
                        cs.release();
                        break;
                    }
                    System.out.print("B");
                }catch(InterruptedException ex){

                }finally{
                    cs.release();
                }
            }
        }
    }

    private static class PrintC implements Runnable
    {
        public void run(){
            while(true){
                try{
                    cs.acquire();
                    System.out.print("C");
                    count++;
                    //打印10次完成，结束
                    if(count == 10){
                        as.release();
                        break;
                    }
                }catch(InterruptedException ex){

                }finally{
                    as.release();
                }
            }
        }
    }
}
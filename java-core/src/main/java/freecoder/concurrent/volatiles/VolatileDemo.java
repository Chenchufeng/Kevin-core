package freecoder.concurrent.volatiles;

/**
 * @Author: Kevin
 * @Date: 2021/12/19 20:16
 * @Description:
 */
public class VolatileDemo {
    public static volatile boolean finishFlag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int i = 0;
            while (!finishFlag){
                i++;
            }
        },"t1").start();
        Thread.sleep(1000);//确保t1先进入while循环后主线程才修改finishFlag
        finishFlag = true;
    }
}
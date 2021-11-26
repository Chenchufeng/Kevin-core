package freecoder.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Kevin
 * @Date: 2021/11/26 23:39
 * @Description:
 */
public class concurrent5 {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random()* 2000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("游戏开始");
    }
}
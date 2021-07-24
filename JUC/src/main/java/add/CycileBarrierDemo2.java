package add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: Kevin
 * @Date: 2021/7/24 13:18
 * @Description: 集齐七颗龙珠召唤神龙
 */
public class CycileBarrierDemo2 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功");
        });
        for (int i = 1; i <=7; i++) {
            //lambda操作不到i
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
                try {
                    barrier.await(); //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
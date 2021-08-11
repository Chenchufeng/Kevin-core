package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 01:05
 * @Description:
 */
public class THreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start=System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread=new Thread(){
                @Override
                public void run(){
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("时间:"+(System.currentTimeMillis()-start));
        System.out.println("大小"+list.size());
    }
}
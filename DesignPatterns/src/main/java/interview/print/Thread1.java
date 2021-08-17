package interview.print;

/**
 * @Author: Kevin
 * @Date: 2021/8/7 18:22
 * @Description:
 * // 一个线程打印1-52
 */
public class Thread1 extends Thread {
    private Object obj;

    public Thread1(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            // 打印1-52
            for (int i = 1; i < 53; i++) {
                System.out.print(i + " ");
                if (i % 2 == 0) {
                    // 不能忘了 唤醒其它线程
                    obj.notifyAll();  //当调用obj.notify/notifyAll的时候，正持有obj锁，因此，A1，A2，A3虽被唤醒，但是仍无法获得obj锁。直到B退出synchronized块，释放obj锁后，A1，A2，A3中的一个才有机会获得锁继续执行。
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
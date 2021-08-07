package interview.print;

/**
 * @Author: Kevin
 * @Date: 2021/8/7 18:22
 * @Description: // 另一个线程打印字母A-Z
 */
public class Thread2 extends Thread {
    private Object obj;

    public Thread2(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj)             //同步监视器是obj类，同步代码块是写在run方法里面的。
        {
            // 打印A-Z
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i) + " ");
                // 不能忘了 唤醒其它线程
                obj.notifyAll();
                try {
                    // 最后一个就不要等了
                    if (i != 25) {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static void main(String[] args) {
        {
            Object obj = new Object();
            // 启动两个线程
            Thread1 t1 = new Thread1(obj);

            Thread2 t2 = new Thread2(obj);

            t1.start();
            t2.start();
        }
    }
}
package freecoder.concurrent.synchronizeds;

/**
 * @Author: Kevin
 * @Date: 2021/12/19 19:31
 * @Description:
 * 这里的输出结果我们预期是1000，然而实际上并不一定会输出1000，产生这种状况的原因是存在如下场景：
 * 1、线程1获取count为0，这时候他去执行count++(非原子操作)
 * 2、线程2又去获取count,这时候因为线程A还没有返回结果，所以依然获取到0
 * 3、线程1执行count++后得到count=1，写回内存
 * 4、线程2执行count++后得到count=1，写回内存
 * 5、线程3去获取count，这时候获取到count为1，然而实际上已经执行过2次count++操作了
 * 假如线程是按照上面的1-5个步骤执行的话，就会导致最后的结果不会输出1000，那么如何解决这个问题呢？就是在increment()方法上加上synchronized关键字
 */
public class TestSynchronized {
    public static int count;

    public synchronized static void increment(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->TestSynchronized.increment()).start();
        }
        Thread.sleep(3000);
        System.out.println("结果：" + count);
    }
}
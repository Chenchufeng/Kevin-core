package ticket;

//资源类 OOP
public class Ticket {
    //属性、方法
    private int number = 40;

    //卖票的方式
    // synchronized 本质: 队列，锁
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" +
                    (40 - (--number)) + "张票，剩余:" + number + "张票");
        }
    }
}

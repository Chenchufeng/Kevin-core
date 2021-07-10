package ticket;

public class SaleTicketTDemo01 {
    /*
     * 真正的多线程开发，公司中的开发，降低耦合性
     * 线程就是一个单独的资源类，没有任何附属的操作！
     * 1、 属性、方法
     */
    public static void main(String[] args) {
        //并发：多个线程同时操作一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();
        // @FunctionalInterface 函数式接口，jdk1.8 lambada表达式
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

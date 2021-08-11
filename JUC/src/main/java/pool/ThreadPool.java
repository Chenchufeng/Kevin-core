package pool;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 00:59
 * @Description:
 */
public class ThreadPool extends Thread{
    String name;

    public ThreadPool(String name){
        this.name=name;
    }
    @Override
    public void run(){
        System.out.println(name+"好");
    }


    public static void main(String[] args) {
//        new ThreadPool("Monkey老师").run();
        new ThreadPool("Monkey老师").start();
    }
}
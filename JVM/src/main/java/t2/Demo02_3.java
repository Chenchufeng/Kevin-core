package t2;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kevin
 * @Date: 2021/10/29 00:10
 * @Description: 演示软引用
 * -Xmx20m -XX:+PrintGCDetails
 */
public class Demo02_3 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
//        List<Byte[]> list=new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new Byte[_4MB]);
//        }
//        System.in.read();
        soft();
    }

    public static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            //关联了引用队列，当软引用所关联的byte被回收时，软引用自己会加入到queue中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        //从队列中获取无用的软引用对象，并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll=queue.poll();
        }
        System.out.println("=========================== "+"list的大小: "+list.size());
        for (SoftReference<byte[]> reference:list){
            System.out.println(reference.get());
        }
    }
}
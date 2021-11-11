package t2;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kevin
 * @Date: 2021/10/29 21:25
 * @Description: 演示软引用
 * * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo02_5 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        //list -->  WeakReference --> byte[]
        List<WeakReference<byte[]>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> reference : list) {
                System.out.print(reference.get() + " ");
            }
            System.out.println();
        }
        System.out.println("循环结束:"+list.size());
    }
}
package threadlocal;


import java.lang.ref.WeakReference;

/**
 * @Author: Kevin
 * @Date: 2021/8/24 00:33
 * @Description: 模拟THreadLocal为什么在gc是Entry<THreadLocal,Object>中的key为何没有被回收
 */
public class TestThreadLocalLeak {

    public static void main(String[] args) {
        String str = new String("Test ThreadLocal memory leak");
        WeakReference<String> weakReference = new WeakReference<>(str);
        System.gc();
        if (weakReference.get()==null){
            System.out.println("WeakReference 已经被GC回收");
        }
        else{
            System.out.println(weakReference.get());
        }
    }
}
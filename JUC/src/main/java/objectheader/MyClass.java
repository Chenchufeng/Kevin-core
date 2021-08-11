package objectheader;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: Kevin
 * @Date: 2021/8/11 23:04
 * @Description:
 */
public class MyClass {
    char c='a';
    int s=100;
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        //打印出相关的对象头信息
        System.out.println(ClassLayout.parseInstance(myClass).toPrintable());
    }
}
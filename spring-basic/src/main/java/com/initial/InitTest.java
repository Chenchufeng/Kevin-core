package com.initial;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 23:28
 * @Description:
 */
public class InitTest {
    public static void main(String[] args) {
        //对于静态字段，只有直接定义这个字段的类才会被初始化，通过其子类来引用父类中定义的静态字段，只会触发其父类的初始化而不会触发子类的初始化。
//        System.out.println(SubClass.value);


        //通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] test = new SuperClass[10]; //输出结果：没有任何输出结果
    }
}
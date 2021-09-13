package com.initial;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 23:26
 * @Description:
 */
public class SuperClass {
    //静态变量value
    public static int value =123456;
    //静态块，父类初始化时会调用
    static{
        System.out.println("父类初始化！");
    }
}


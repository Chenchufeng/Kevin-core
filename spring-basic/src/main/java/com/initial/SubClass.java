package com.initial;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 23:27
 * @Description:
 */
public class SubClass extends SuperClass{
    //静态块，子类初始化时会调用
    static{
        System.out.println("子类初始化！");
    }
}
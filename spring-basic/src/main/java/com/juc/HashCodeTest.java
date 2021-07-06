package com.juc;
/**
  * @Author: chufeng Chen
  * @Description:
  * @Date:Create：in  2021/6/24 23:49
  */public class HashCodeTest {
    public static void main(String[] args) {
        Object object = new Object();
        //通过调用hashCode()方法获取对象的hash值
        System.out.println(object.hashCode());
    }
}

package com.serializable;

import java.io.*;

/**
 * @Author: Kevin
 * @Date: 2021/8/18 12:46
 * @Description: 被标记为transient的属性在对象被序列化的时候不会被保存。
 */
public class TestTransient {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Kevin", "123456");
//        System.out.println(userInfo);
        try {
            // 序列化，被设置为transient的属性没有被序列化
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
            o.writeObject(userInfo);
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("UserInfo.out"));
            Object readUserInfo = inputStream.readObject();
            //读取后psw的内容为null
            System.out.println(readUserInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
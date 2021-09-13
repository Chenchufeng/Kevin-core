package com.reflection;

import java.lang.reflect.Field;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 23:47
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Employee e = new Employee("Harry Hacker", 560000, 2012,3,4);
        System.out.println(e.getClass().getName() + " " + e.getName());

        //获取Class对象的第一种方法：对象实例调用getClass()方法
        Class<? extends Employee> c1 = e.getClass();
        String c1Name = c1.getName();
        System.out.println(c1Name);

        //获取Class对象的第二种方法：调用静态方法forName
        String className = "java.util.Random";
        Class<?> c2 = Class.forName(className);
        System.out.println(c2.getName());

        //获取Class对象的第三种方法：如果T是任意的Java类型，使用T.class
        Class c3 = Double[].class;
        System.out.println(c3.getName());

        System.out.println("-------------------------------------------------");
        //获取雇员类的name字段，并对它进行修改
        Field field = c1.getDeclaredField("name");
        System.out.println(field);
        //由于是私有域，所以要县使用setAccessible方法来覆盖访问控制
        field.setAccessible(true);
        //get方法返回的是Object对象，要想正常打印，需要进行类型转换
        Object v = field.get(e);
        System.out.println((String) v);
        //set方法可以更改对应字段的值
        field.set(e,"Tom Smith");
        System.out.println((String) field.get(e));
    }
}
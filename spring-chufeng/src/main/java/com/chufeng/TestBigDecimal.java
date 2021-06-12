package com.chufeng;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author: chufeng Chen
 * @Description: https://github.com/Snailclimb/JavaGuide
 * @Date:Create：in 2021/5/27 23:33
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        /**
         * 浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。
         */
        float a1 = 1.0f - 0.9f;
        float b1 = 0.9f - 0.8f;
        System.out.println(a1);// 0.100000024
        System.out.println(b1);// 0.099999964
        System.out.println(a1 == b1);// false
        System.out.println("===============================================\r\n");
        //具有基本数学知识的我们很清楚的知道输出并不是我们想要的结果（精度丢失），我们如何解决这个问题呢？一种很常用的方法是：使用 BigDecimal 来定义浮点数的值，再进行浮点数的运算操作。
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */
        System.out.println("===============================================\r\n");
        //BigDecimal 的大小比较
        //a.compareTo(b) : 返回 -1 表示 a 小于 b，0 表示 a 等于 b ， 1表示 a 大于 b。

        BigDecimal f1 = new BigDecimal("1.0");
        BigDecimal f2 = new BigDecimal("0.9");
        System.out.println(f1.compareTo(f2));// 1
        System.out.println("===============================================\r\n");
        //BigDecimal 保留几位小数
        //通过 setScale方法设置保留几位小数以及保留规则。保留规则有挺多种，不需要记，IDEA会提示。
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255
    }
}

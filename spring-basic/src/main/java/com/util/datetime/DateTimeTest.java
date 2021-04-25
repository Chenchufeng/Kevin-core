package com.util.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/25 13:20
 */
public class DateTimeTest {
    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     * 两个操作：
     * 1.格式化：日期--->字符串
     * 2.解析：格式化的逆过程，字符串---->日期
     */
    public static void testSimpleDateFormat() throws ParseException {
        //使用默认构造器实例化
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串---->日期
        Date parse = sdf.parse("21-4-25 下午1:27");
        System.out.println(parse);
    }

    //*******************************************************************************
    //按照指定的方式格式化和解析，调用带参的构造器
    public static void testSimpleDateFormat2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
        //解析
        Date date2 = sdf.parse("2022-08-18 01:31:36");
        System.out.println(date2);
    }

    /**
     *练习1：字符串"2020-09-08"转换为java.sql.Date
     * @param args
     */
    public static void practice1(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//月份一定是大写MM
        String birth="2020-09-08";
        try {
            Date date = dateFormat.parse(birth);
            java.sql.Date birthDate=new java.sql.Date(date.getTime());
            System.out.println(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**面试题：
     * 练习2：“三天打渔，两天晒网”  1990-01-01   XXXX-XX-XX 打渔？晒网
     * 举例：2020-09-08？总天数
     * 总天数%5 ==1,2,3 打渔
     * 总天数%5 ==4,0 晒网
     * 总天数的计算：(date2.getTime()-date2.getTime())/(1000*60*60*24)+1
     * @param args
     */
    public static void practice2(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String init="1990-01-01";
        long count;
        try {
            Date initDate = format.parse(init);
            Date endDate = new Date();
            String format_endDate = format.format(endDate);
            count=(endDate.getTime()-initDate.getTime())/(1000*60*60*24)+1;
            System.out.println("总天数："+count);
            if (count%5==1 || count%5==2 ||count%5==3){
                System.out.println(format_endDate+"这天在打渔");
            }
            if(count%5==4 || count%5==0){
                System.out.println(format_endDate+"这天在晒网");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

//            testSimpleDateFormat2();
//            practice1();

        practice2();
    }
}

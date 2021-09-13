package com.reflection;

import java.time.LocalDate;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 23:46
 * @Description:
 */
public class Employee {
    private String name; //姓名
    private double salary; //薪水
    private LocalDate hireDay; //雇用日期

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * 按百分比提升员工工资
     * @param byPercent
     */
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
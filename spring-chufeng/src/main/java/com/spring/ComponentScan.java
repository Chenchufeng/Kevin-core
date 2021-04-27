package com.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/27 22:27
 */
@Retention(RetentionPolicy.RUNTIME)//运行时保留
@Target(ElementType.TYPE) //类、接口（包括注解类型）和枚举的声明
public @interface ComponentScan {
    String value() default "";//注解的属性，默认值为空
}

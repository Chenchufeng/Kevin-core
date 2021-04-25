package com.Kevin.entry;

import com.Kevin.app.AppConfig;
import com.Kevin.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/8 21:45
 */
public class TestBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean(UserService.class));


    }
}

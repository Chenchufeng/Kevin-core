package com.chufeng;

import com.service.UserService;
import com.spring.ChufengApplicationContext;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/27 22:20
 */
public class Test {
    public static void main(String[] args) {
        ChufengApplicationContext context = new ChufengApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}

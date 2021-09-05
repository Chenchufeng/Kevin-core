package com.kevin.security.sprngmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author: Kevin
 * @Date: 2021/9/5 22:58
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "com.kevin.security.springmvc",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION ,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
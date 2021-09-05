package com.kevin.security.sprngmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: Kevin
 * @Date: 2021/9/5 23:05
 * @Description:
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.kevin.security.springmvc", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    //视频解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB‐INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
package com.kevin.security.sprngmvc.init;

import com.kevin.security.sprngmvc.config.ApplicationConfig;
import com.kevin.security.sprngmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: Kevin
 * @Date: 2021/9/5 23:26
 * @Description:
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class}; //指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};  //指定servletContext的配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
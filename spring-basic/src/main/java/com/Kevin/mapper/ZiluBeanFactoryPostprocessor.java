package com.Kevin.mapper;

import com.Kevin.services.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/8 22:16
 */
@Component
public class ZiluBeanFactoryPostprocessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition service = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexService");
        service.setBeanClass(UserService.class);

    }
}

package com.spring;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/28 22:33
 */
public class BeanDefinition {
    private Class clazz;
    private String scope;


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}

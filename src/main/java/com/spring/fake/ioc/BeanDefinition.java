package com.spring.fake.ioc;

/**
 * bean
 * Created by tnpla on 2019/1/21.
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}

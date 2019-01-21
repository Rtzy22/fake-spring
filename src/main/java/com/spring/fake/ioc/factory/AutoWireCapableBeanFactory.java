package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;

/**
 * Created by tnpla on 2019/1/21.
 */
public class AutoWireCapableBeanFactory extends AbstractBeanFactory {

    protected Object createBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

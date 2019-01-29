package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;

/**
 * bean工厂
 * Created by tnpla on 2019/1/21.
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void preInstantiateSingletons() throws Exception;
}

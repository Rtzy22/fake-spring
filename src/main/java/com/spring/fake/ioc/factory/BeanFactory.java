package com.spring.fake.ioc.factory;

/**
 * bean工厂
 * Created by tnpla on 2019/1/21.
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

}

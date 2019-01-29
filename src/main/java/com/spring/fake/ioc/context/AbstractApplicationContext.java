package com.spring.fake.ioc.context;

import com.spring.fake.ioc.factory.AbstractBeanFactory;

/**
 * Created by tnpla on 2019/1/29.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory abstractBeanFactory;

    public AbstractApplicationContext(AbstractBeanFactory abstractBeanFactory) {
        this.abstractBeanFactory = abstractBeanFactory;
    }

    public abstract void refresh() throws Exception;

    public Object getBean(String beanName) throws Exception {
        return abstractBeanFactory.getBean(beanName);
    }
}

package com.spring.fake.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂
 * Created by tnpla on 2019/1/21.
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}

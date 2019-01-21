package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象bean工厂
 * Created by tnpla on 2019/1/21.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    // 获取bean
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    // 注册bean
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Object bean = createBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName, beanDefinition);

    }

    /**
     * 创建bean实例,交给具体子类创建
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(BeanDefinition beanDefinition);
}

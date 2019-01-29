package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象bean工厂
 * Created by tnpla on 2019/1/21.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    // 获取bean, 采用lazy-init的方式, 需要的时候再去创建bean
    public Object getBean(String beanName) throws Exception {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new IllegalArgumentException("No bean named " + beanName + "");
        }

        Object bean = beanDefinition.getBean();
        if (null == bean) {
            bean = createBean(beanDefinition);
        }
        return bean;
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

        // 注册bean
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
//        Object bean = createBean(beanDefinition);
//        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    /**
     * 创建bean实例,交给具体子类创建
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(BeanDefinition beanDefinition) throws Exception;
}

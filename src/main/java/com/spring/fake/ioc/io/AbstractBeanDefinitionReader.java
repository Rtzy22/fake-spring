package com.spring.fake.ioc.io;

import com.spring.fake.ioc.BeanDefinition;
import com.spring.fake.ioc.BeanDefinitionReader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从配置中读取Bean, loadBeanDefinitions读取配置
 * Created by tnpla on 2019/1/22.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

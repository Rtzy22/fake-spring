package com.spring.fake.ioc;

/**
 * 从配置中读取Bean, loadBeanDefinitions读取配置
 * Created by tnpla on 2019/1/22.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String localtion) throws Exception;
}

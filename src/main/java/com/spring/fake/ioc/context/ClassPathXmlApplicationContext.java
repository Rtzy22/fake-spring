package com.spring.fake.ioc.context;

import com.spring.fake.ioc.BeanDefinition;
import com.spring.fake.ioc.factory.AbstractBeanFactory;
import com.spring.fake.ioc.factory.AutoWireCapableBeanFactory;
import com.spring.fake.ioc.io.ResourceLoader;
import com.spring.fake.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by tnpla on 2019/1/29.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutoWireCapableBeanFactory(), configLocation);

    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory abstractBeanFactory, String configLocation) throws Exception {
        super(abstractBeanFactory);
        this.configLocation = configLocation;
        this.refresh();

    }

    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions(this.configLocation);
        for (Map.Entry<String, BeanDefinition> beanEntry : reader.getBeanDefinitionMap().entrySet()) {
            abstractBeanFactory.registerBeanDefinition(beanEntry.getKey(), beanEntry.getValue());
        }
    }
}

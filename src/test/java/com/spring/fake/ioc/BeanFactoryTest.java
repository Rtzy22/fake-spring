package com.spring.fake.ioc;


import com.spring.fake.ioc.testbeans.McHotDog;
import com.spring.fake.ioc.factory.AutoWireCapableBeanFactory;
import com.spring.fake.ioc.factory.BeanFactory;
import com.spring.fake.ioc.io.ResourceLoader;
import com.spring.fake.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by tnpla on 2019/1/21.
 */
public class BeanFactoryTest {

    /**
     * 测试beanFactory
     */
    @Test
    public void test() throws Exception {

        // 0. read xml
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("beans.xml");

        // 1.init beanfactory
        BeanFactory beanFactory = new AutoWireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanEntry : reader.getBeanDefinitionMap().entrySet()) {
            beanFactory.registerBeanDefinition(beanEntry.getKey(), beanEntry.getValue());
        }

//        // 2.registerBean
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassByName("com.spring.fake.bean.McHotDog");
//        beanFactory.registerBeanDefinition("mcHotDog", beanDefinition);
//
//        // 3.set properties
//        Property property = new Property();
//        property.addPropertyValue(new PropertyValue("sing", "rap"));
//        beanDefinition.setProperty(property);

        // 3.init bean
        beanFactory.preInstantiateSingletons();

        // 4.get bean
        McHotDog mcHotDog = (McHotDog) beanFactory.getBean("mcHotDog");
        mcHotDog.getRapper().say();
        mcHotDog.sing();

    }
}

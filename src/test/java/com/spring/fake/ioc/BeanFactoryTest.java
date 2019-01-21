package com.spring.fake.ioc;

import com.spring.fake.bean.McHotDog;
import com.spring.fake.ioc.factory.AutoWireCapableBeanFactory;
import com.spring.fake.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by tnpla on 2019/1/21.
 */
public class BeanFactoryTest {

    /**
     * 测试beanFactory
     */
    @Test
    public void test() {
        // 1.init beanfactory
        BeanFactory beanFactory = new AutoWireCapableBeanFactory();

        // 2.registerBean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassByName("com.spring.fake.bean.McHotDog");
        beanFactory.registerBeanDefinition("mcHotDog", beanDefinition);

        // 3.get bean
        McHotDog mcHotDog = (McHotDog) beanFactory.getBean("mcHotDog");
        mcHotDog.song();
    }
}

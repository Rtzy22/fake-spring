package com.spring.fake.ioc;

import com.spring.fake.bean.McHotDog;
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
        BeanFactory beanFactory = new BeanFactory();

        // 2.registerBean
        BeanDefinition beanDefinition = new BeanDefinition(new McHotDog());
        beanFactory.registBeanDefinition("mcHotDog", beanDefinition);

        // 3.get bean
        McHotDog mcHotDog = (McHotDog) beanFactory.getBean("mcHotDog");
        mcHotDog.song();
    }
}

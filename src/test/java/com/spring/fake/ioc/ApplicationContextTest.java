package com.spring.fake.ioc;

import com.spring.fake.ioc.context.ApplicationContext;
import com.spring.fake.ioc.context.ClassPathXmlApplicationContext;
import com.spring.fake.ioc.testbeans.McHotDog;
import org.junit.Test;

/**
 * Created by tnpla on 2019/1/29.
 */
public class ApplicationContextTest {

    /**
     * 测试ClassPathXmlApplicationContext, 采用lazy-init方式加载bean
     */
    @Test
    public void test() throws Exception {
        ApplicationContext context  = new ClassPathXmlApplicationContext("beans.xml");
        McHotDog           mcHotDog = (McHotDog) context.getBean("mcHotDog");

        mcHotDog.getRapper().say();
        mcHotDog.sing();
    }

}

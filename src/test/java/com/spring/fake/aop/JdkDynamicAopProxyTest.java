package com.spring.fake.aop;

import com.spring.fake.aop.testbeans.HelloService;
import com.spring.fake.aop.testbeans.impl.HelloServiceImpl;
import com.spring.fake.ioc.context.ApplicationContext;
import com.spring.fake.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by tnpla on 2019/2/7.
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloServiceImpl   hello   = (HelloServiceImpl) context.getBean("helloService");
        hello.sayHi();

        // 1. 设置被代理对象(Joinpoint)
        TargetSource targetSource = new TargetSource(hello, HelloService.class);
        AdvisedSupport advise = new AdvisedSupport();
        advise.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advise.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advise);
        HelloService helloService = (HelloService) jdkDynamicAopProxy.getProxy();

        // 3. 基于AOP的调用
        helloService.sayHi();
    }
}

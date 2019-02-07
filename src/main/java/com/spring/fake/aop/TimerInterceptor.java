package com.spring.fake.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 代理类, timerInterceptor
 * Created by tnpla on 2019/2/7.
 */
public class TimerInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        long start = System.nanoTime();
        System.out.println("invocation of method " + methodInvocation.getMethod().getName() + " start!");

        Object proceed = methodInvocation.proceed();

        System.out.println("invocation of method " + methodInvocation.getMethod().getName() + " end! takes " +
                (System.nanoTime() - start) / 1000.0 + "ms");
        return proceed;
    }
}

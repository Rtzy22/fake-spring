package com.spring.fake.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于jdk的动态代理实现
 * Created by tnpla on 2019/2/7.
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{advisedSupport.getTargetSource().getTargetClass()},
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor interceptor = advisedSupport.getMethodInterceptor();

        Object invoke = interceptor.invoke(new ReflectiveMethodInvocation(
                advisedSupport.getTargetSource().getTarget(),
                method,
                args));

        return invoke;
    }
}

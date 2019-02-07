package com.spring.fake.aop;

/**
 * 被代理对象
 * Created by tnpla on 2019/2/7.
 */
public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}

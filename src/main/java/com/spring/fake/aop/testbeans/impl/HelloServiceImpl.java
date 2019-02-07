package com.spring.fake.aop.testbeans.impl;

import com.spring.fake.aop.testbeans.HelloService;

/**
 * Created by tnpla on 2019/2/7.
 */
public class HelloServiceImpl implements HelloService {
    public void sayHi() {
        System.out.println("Hello World");
    }
}

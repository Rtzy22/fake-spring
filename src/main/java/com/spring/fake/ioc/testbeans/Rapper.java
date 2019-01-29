package com.spring.fake.ioc.testbeans;

/**
 * Created by tnpla on 2019/1/28.
 */
public class Rapper {
    private String name;

    public void say() {
        System.out.println("Hello, 我是说唱歌手:" + this.name);
    }
}

package com.spring.fake.ioc;

/**
 * Created by tnpla on 2019/1/28.
 */
public class BeanReference {
    private String name;
    private String bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }
}

package com.spring.fake.ioc;

/**
 * bean的属性注入
 * Created by tnpla on 2019/1/22.
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }


}

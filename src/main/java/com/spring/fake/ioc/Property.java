package com.spring.fake.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 包装bean的propeties
 * Created by tnpla on 2019/1/22.
 */
public class Property {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public Property() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}

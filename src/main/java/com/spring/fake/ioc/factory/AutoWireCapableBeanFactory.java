package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;
import com.spring.fake.ioc.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by tnpla on 2019/1/21.
 */
public class AutoWireCapableBeanFactory extends AbstractBeanFactory {

    protected Object createBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();

            setBeanField(beanDefinition, bean);

            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 设置bean的成员变量
    private void setBeanField(BeanDefinition beanDefinition, Object bean) throws NoSuchFieldException, IllegalAccessException {
        List<PropertyValue> values = beanDefinition.getProperty().getPropertyValueList();
        for (PropertyValue value : values) {
            Field field = bean.getClass().getDeclaredField(value.getName());
            field.setAccessible(true);
            field.set(bean, value.getValue());
        }
    }
}

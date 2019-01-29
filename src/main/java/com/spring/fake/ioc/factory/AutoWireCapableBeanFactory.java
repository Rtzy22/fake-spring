package com.spring.fake.ioc.factory;

import com.spring.fake.ioc.BeanDefinition;
import com.spring.fake.ioc.BeanReference;
import com.spring.fake.ioc.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by tnpla on 2019/1/21.
 */
public class AutoWireCapableBeanFactory extends AbstractBeanFactory {

    protected Object createBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        setBeanField(beanDefinition, bean);
        beanDefinition.setBean(bean);
        return bean;

    }

    // 设置bean的成员变量
    private void setBeanField(BeanDefinition beanDefinition, Object bean) throws Exception {
        List<PropertyValue> values = beanDefinition.getProperty().getPropertyValueList();
        for (PropertyValue value : values) {
            Field field = bean.getClass().getDeclaredField(value.getName());
            field.setAccessible(true);
            Object beanValue = value.getValue();

            // 如果属于注入当前bean中的其他的bean, 则set到的bean的成员变量
            if (beanValue instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) beanValue;
                beanValue = getBean(beanReference.getName());
            }
            field.set(bean, beanValue);
        }
    }
}

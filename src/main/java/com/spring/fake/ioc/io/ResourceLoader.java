package com.spring.fake.ioc.io;

import java.net.URL;

/**
 * 资源装载器
 * Created by tnpla on 2019/1/22.
 */
public class ResourceLoader {

    public Resource getResource(String address) {
        URL url = this.getClass().getClassLoader().getResource(address);
        return new ClassUrlResource(url);
    }
}

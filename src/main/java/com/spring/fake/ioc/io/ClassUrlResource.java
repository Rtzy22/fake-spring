package com.spring.fake.ioc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类的url资源读取
 * Created by tnpla on 2019/1/22.
 */
public class ClassUrlResource implements Resource {

    private final URL url;

    public ClassUrlResource(URL url) {
        this.url = url;
    }

    public InputStream getInputStream() throws IOException {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}

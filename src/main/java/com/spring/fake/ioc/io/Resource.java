package com.spring.fake.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tnpla on 2019/1/22.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}

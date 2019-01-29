package com.spring.fake.ioc.xml;

import com.spring.fake.ioc.BeanDefinition;
import com.spring.fake.ioc.BeanReference;
import com.spring.fake.ioc.PropertyValue;
import com.spring.fake.ioc.io.AbstractBeanDefinitionReader;
import com.spring.fake.ioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by tnpla on 2019/1/22.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinitions(String localtion) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(localtion).getInputStream();

        // 读取xml配置, 封装成Document
        DocumentBuilderFactory factory         = DocumentBuilderFactory.newInstance();
        DocumentBuilder        documentBuilder = factory.newDocumentBuilder();
        Document               document        = documentBuilder.parse(inputStream);

        // 解析dom标签, 注入bean
        registerBeanDefinitions(document);
        inputStream.close();

    }

    // 注入bean
    private void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);

            if (item instanceof Element) {
                Element e = (Element) item;
                processBeanDefinitions(e);
            }
        }
    }

    private void processBeanDefinitions(Element e) {
        String name       = e.getAttribute("name");
        String classsName = e.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(e, beanDefinition);
        beanDefinition.setBeanClassByName(classsName);
        getBeanDefinitionMap().put(name, beanDefinition);

    }

    private void processProperty(Element etree, BeanDefinition beanDefinition) {
        NodeList propertyNode = etree.getElementsByTagName("property");
        Element  e            = null;

        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);

            if (node instanceof Element) {
                e = (Element) node;
                String name  = e.getAttribute("name");
                String value = e.getAttribute("value");

                if (null != value && value.length() > 0) {
                    beanDefinition.getProperty().addPropertyValue(new PropertyValue(name, value));
                } else {
                    // 读取不到value时, 读取ref
                    String ref = e.getAttribute("ref");
                    if (null == ref && ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property " +
                                name + " ref must specify a ref or value");
                    }

                    BeanReference beanReference = new BeanReference(name);
                    beanDefinition.getProperty().addPropertyValue(new PropertyValue(name, beanReference));
                }

            }
        }

    }
}

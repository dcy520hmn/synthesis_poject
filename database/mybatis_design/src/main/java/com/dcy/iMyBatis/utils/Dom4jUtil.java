package com.dcy.iMyBatis.utils;

import com.dcy.iMyBatis.config.Configuration;
import com.dcy.iMyBatis.config.Mapper;
import com.dcy.iMyBatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dom4jUtil {

    /**
     * 解析mapper文件
     *
     * @param config
     * @return
     */
    public static Configuration analysisXml(InputStream config) {
        Configuration configuration;
        try {
            configuration = new Configuration();
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(config);
            //设置数据库连接信息
            Element configurationEmt = document.getRootElement();
            Element environments = configurationEmt.element("environments");
            Element environment = environments.element("environment");
            Element dataSource = environment.element("dataSource");
            List<Element> elements = dataSource.elements();
            elements.forEach(property -> {
                String name = property.attributeValue("name");
                switch (name) {
                    case "driver":
                        configuration.setDriver(property.attributeValue("value"));
                        break;
                    case "url":
                        configuration.setUrl(property.attributeValue("value"));
                        break;
                    case "username":
                        configuration.setUsername(property.attributeValue("value"));
                        break;
                    case "password":
                        configuration.setPassword(property.attributeValue("value"));
                        break;
                }
            });
            //设置mapper
            Element mappers = configurationEmt.element("mappers");
            List<Element> mapperList = mappers.elements();
            Map<String,Mapper> mapperMap = new HashMap<>();
            mapperList.forEach(mapper->{
                String resource = mapper.attributeValue("resource");
                InputStream mapperInputStream = Resources.getResourceAsStream(resource);
                //设置mapper
                configMapper(mapperInputStream,mapperMap);
            });
            configuration.setMappers(mapperMap);
            return configuration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置mapper
     * @param mapperInputStream
     */
    private static void configMapper(InputStream mapperInputStream, Map mapperMap) {
        SAXReader saxReader = new SAXReader();
        try {
            Document read = saxReader.read(mapperInputStream);
            Element mapperEmt = read.getRootElement();
            String nameSpace = mapperEmt.attributeValue("namespace");
            List<Element> elements = mapperEmt.elements();
            elements.forEach(element -> {
                String id = element.attributeValue("id");
                //设置key
                String key = nameSpace+"."+id;
                //设置mapper
                Mapper mapper = new Mapper();
                mapper.setResultType(element.attributeValue("resultType"));
                mapper.setSql(element.getText());
                mapperMap.put(key,mapper);
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

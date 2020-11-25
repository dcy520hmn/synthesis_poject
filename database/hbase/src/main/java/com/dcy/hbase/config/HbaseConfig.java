package com.dcy.hbase.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@ConfigurationProperties(prefix="hbase")
public class HbaseConfig {

    public static Map<String,String> CONFIG_MAP;

    public void setConfigMap(Map<String, String> configMap) {
        CONFIG_MAP = configMap;
    }

    public static org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        Map<String, String> config = HbaseConfig.CONFIG_MAP;
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            configuration.set(key, config.get(key));
        }
        return configuration;
    }
}
package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig01 {
//    @Autowired
//    private JdbcProperties jdbcProperties;
//    @Bean
//    public DataSource getDruidDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(jdbcProperties.getUrl());
//        druidDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
//        druidDataSource.setUsername(jdbcProperties.getUsername());
//        druidDataSource.setPassword(jdbcProperties.getPassword());
//        return druidDataSource;
//    }


    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }



}

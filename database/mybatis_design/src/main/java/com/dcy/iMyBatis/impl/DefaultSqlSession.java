package com.dcy.iMyBatis.impl;

import com.dcy.iMyBatis.SqlSession;
import com.dcy.iMyBatis.config.Configuration;
import com.dcy.iMyBatis.proxy.MapperProxy;
import com.dcy.iMyBatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 具体的SqlSession实现
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession() {
    }

    /**
     * 创建SqlSession，根据配置信息获得connection
     * @param configuration
     */
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }

    /**
     * 获取代理对象
     * @param daoClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoClass) {
        MapperProxy mapperProxy = new MapperProxy(connection,configuration.getMappers());
        return (T) Proxy.newProxyInstance(daoClass.getClass().getClassLoader(),new Class[]{daoClass}, mapperProxy);
    }

    /**
     * 释放资源
     */
    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

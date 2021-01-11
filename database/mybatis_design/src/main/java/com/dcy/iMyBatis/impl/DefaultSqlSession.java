package com.dcy.iMyBatis.impl;

import com.dcy.iMyBatis.SqlSession;
import com.dcy.iMyBatis.config.Configuration;
import com.dcy.iMyBatis.proxy.MapperProxy;
import com.dcy.iMyBatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * �����SqlSessionʵ��
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession() {
    }

    /**
     * ����SqlSession������������Ϣ���connection
     * @param configuration
     */
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }

    /**
     * ��ȡ�������
     * @param daoClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoClass) {
        MapperProxy mapperProxy = new MapperProxy(connection,configuration.getMappers());
        return (T) Proxy.newProxyInstance(daoClass.getClass().getClassLoader(),new Class[]{daoClass}, mapperProxy);
    }

    /**
     * �ͷ���Դ
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

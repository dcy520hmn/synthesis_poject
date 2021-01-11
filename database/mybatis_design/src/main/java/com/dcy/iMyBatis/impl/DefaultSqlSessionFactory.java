package com.dcy.iMyBatis.impl;

import com.dcy.iMyBatis.SqlSession;
import com.dcy.iMyBatis.SqlSessionFactory;
import com.dcy.iMyBatis.config.Configuration;


public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory() {
    }

    /**
     * 加载配置信息
     * @param configuration
     */
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 创建sqlSession
     * @return
     */
    public SqlSession openSession() {
        //根据configuration获取connection
        return new DefaultSqlSession(configuration);
    }

}

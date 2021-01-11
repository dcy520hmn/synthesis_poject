package com.dcy.iMyBatis.impl;

import com.dcy.iMyBatis.SqlSession;
import com.dcy.iMyBatis.SqlSessionFactory;
import com.dcy.iMyBatis.config.Configuration;


public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory() {
    }

    /**
     * ����������Ϣ
     * @param configuration
     */
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * ����sqlSession
     * @return
     */
    public SqlSession openSession() {
        //����configuration��ȡconnection
        return new DefaultSqlSession(configuration);
    }

}

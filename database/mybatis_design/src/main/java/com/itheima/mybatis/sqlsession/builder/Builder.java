package com.itheima.mybatis.sqlsession.builder;

import com.itheima.mybatis.sqlsession.SqlSessionFactory;

import java.io.InputStream;

public interface Builder {
    SqlSessionFactory build(InputStream config);
}

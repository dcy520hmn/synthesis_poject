package com.dcy.iMyBatis.buider;

import com.dcy.iMyBatis.SqlSessionFactory;

import java.io.InputStream;

/**
 * ����������������Լ��
 */
public interface Builder {
    SqlSessionFactory build(InputStream config);
}

package com.dcy.iMyBatis.buider;

import com.dcy.iMyBatis.config.Configuration;
import com.dcy.iMyBatis.utils.Dom4jUtil;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;
import com.itheima.mybatis.sqlsession.builder.Builder;

import java.io.InputStream;

/**
 * ���������幹���ߣ�ʵ�ֹ�����ϸ��
 */
public class SqlSessionFactoryBuilder implements Builder {

    public SqlSessionFactory build(InputStream config) {
        Configuration configMapper = Dom4jUtil.analysisXml(config);
        return null;
    }

}

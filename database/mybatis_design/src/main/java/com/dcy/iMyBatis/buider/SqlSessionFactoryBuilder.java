package com.dcy.iMyBatis.buider;

import com.dcy.iMyBatis.SqlSessionFactory;
import com.dcy.iMyBatis.config.Configuration;
import com.dcy.iMyBatis.impl.DefaultSqlSessionFactory;
import com.dcy.iMyBatis.utils.Dom4jUtil;


import java.io.InputStream;

/**
 * 描述：具体构建者，实现构建的细节
 */
public class SqlSessionFactoryBuilder implements Builder {

    public SqlSessionFactory build(InputStream config) {
        Configuration configuration = Dom4jUtil.analysisXml(config);
        return new DefaultSqlSessionFactory(configuration);
    }

}

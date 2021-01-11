package com.dcy.iMyBatis.buider;

import com.dcy.iMyBatis.SqlSessionFactory;

import java.io.InputStream;

/**
 * 描述：构建者流程约束
 */
public interface Builder {
    SqlSessionFactory build(InputStream config);
}

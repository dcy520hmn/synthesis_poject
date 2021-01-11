package com.dcy.iMyBatis;

/**
 * 工厂模式
 *  功能：获取sqlSession
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}

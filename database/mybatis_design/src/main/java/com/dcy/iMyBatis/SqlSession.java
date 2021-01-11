package com.dcy.iMyBatis;

public interface SqlSession {

    /**
     * 获得代理对象
     * @param daoClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoClass);

    /***
     * 释放资源
     */
    void close();
}

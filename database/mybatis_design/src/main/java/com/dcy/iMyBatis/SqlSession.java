package com.dcy.iMyBatis;

public interface SqlSession {

    /**
     * ��ô������
     * @param daoClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoClass);

    /***
     * �ͷ���Դ
     */
    void close();
}

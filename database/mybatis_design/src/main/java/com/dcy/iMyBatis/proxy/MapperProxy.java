package com.dcy.iMyBatis.proxy;

import com.dcy.iMyBatis.config.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Connection connection;
    private Map<String, Mapper> mappers;

    public MapperProxy() {
    }


    public MapperProxy(Connection connection, Map<String, Mapper> mappers) {
        this.connection = connection;
        this.mappers = mappers;
    }

    /**
     * 代理对象执行时的回调方法，自此执行sql查询。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}

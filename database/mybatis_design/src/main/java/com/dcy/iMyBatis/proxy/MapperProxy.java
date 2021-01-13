package com.dcy.iMyBatis.proxy;

import com.dcy.iMyBatis.config.Mapper;
import com.dcy.iMyBatis.utils.ExecuteSql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

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
     * �������ִ��ʱ�Ļص��������Դ�ִ��sql��ѯ��
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //���ݵ��õķ���������ѯmapper�е�key�����Ҷ�ӦMapper
        String keyOfMapper = "";
        String methodName = method.getName();
        Set<String> keys = mappers.keySet();
        for (String key : keys) {
            String[] split = key.split("\\.");
            String configMethod = split[split.length-1];
            if(methodName.equals(configMethod)){
                keyOfMapper = key;
                break;
            }
        }

        //��ѯ�󽫽����װ��ʵ�����С�
        if(!"".equals(keyOfMapper)){
            Mapper mapper = mappers.get(keyOfMapper);
            return ExecuteSql.selectAll(connection, mapper);
        }else{
            throw new RuntimeException("no method in xml");
        }
    }

}

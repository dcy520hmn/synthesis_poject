package com.dcy.iMyBatis.utils;

import com.dcy.iMyBatis.config.Mapper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ExecuteSql {

    /**
     * ��ѯ���м�¼
     * @param <T>
     * @return
     */
    public static <T> List<T> selectAll(Connection connection, Mapper mapper)  {
        ArrayList<T> list = new ArrayList<T>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement  = connection.prepareStatement(mapper.getSql());
            resultSet  = preparedStatement.executeQuery();
            //������е�����
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //��÷�װ�Ķ���
            Class<?> aClass = Class.forName(mapper.getResultType());
            //ʵ��������
            T pojo = (T)aClass.newInstance();
            while(resultSet.next()){
                //�������װ�������С�
                for (int i = 0; i < columnCount; i++) {
                    //���ֶθ�ֵ
                    String columnName = metaData.getColumnName(i+1);
                    Field declaredField = pojo.getClass().getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(pojo,resultSet.getObject(columnName));
                    //
                }
                list.add(pojo);
            }
            return list;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            release(preparedStatement,resultSet);
        }
    }

    private static void release(PreparedStatement preparedStatement, ResultSet resultSet) {
        if(resultSet != null){
            try {
                resultSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}

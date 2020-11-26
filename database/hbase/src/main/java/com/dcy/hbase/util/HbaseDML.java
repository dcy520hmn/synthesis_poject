package com.dcy.hbase.util;

import com.dcy.hbase.config.HbaseConfig;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class HbaseDML<T> {

    private static Connection connection = null;
    private static Admin admin = null;

    private static final Logger logger = LoggerFactory.getLogger(HbaseDML.class);

    @PostConstruct
    public void init() {
        if (connection != null) {
            return;
        }
        try {
            connection = ConnectionFactory.createConnection(HbaseConfig.configuration());
            admin = connection.getAdmin();
        } catch (Exception e) {
            logger.error("HBase create connection failed: {}", e);
        }
    }

    /**
     * 增加 都是字符型
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param columns
     * @param values
     */
    public void insertOrUpdate(String tableName, String rowKey, String columnFamily, String[] columns, String[] values) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        for (int i = 0;i < columns.length;i++) {
            put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(columns[i]),Bytes.toBytes(values[i]));
        }
        table.put(put);
    }

    /**
     * 增加任意值，不限于String与Long
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param columns
     * @param values
     */
    public void insertOrUpdateAnyType(String tableName,String rowKey,String columnFamily,String[] columns,T[] values) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        for (int i = 0;i < columns.length;i++) {
            byte[] targetType = null;
            if(values[i] instanceof Long){
                targetType = Bytes.toBytes((Long) values[i]);
            }else if(values[i] instanceof String){
                targetType = Bytes.toBytes((String) values[i]);
            }
            put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(columns[i]),targetType);
        }
        table.put(put);
    }
    /**
     * 往表格中追加内容，感觉还不如重新
     * 原来：row1  column=cf1:name, timestamp=2020-11-25T07:32:50.409Z, value=jack1
     * 追加：row1  column=cf1:name, timestamp=2020-11-25T07:32:50.409Z, value=jack1Wang
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @param value
     * @throws IOException
     */
    public void append(String tableName, String rowKey, String columnFamily,String column,String value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Append append = new Append(Bytes.toBytes(rowKey));
        append.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(value));
        table.append(append);
    }

    /**
     * 将数组类型的值增加
     * 原来: row1 column=cf1:age, timestamp=2020-11-25T06:47:30.715Z, value=12
     * 增加：row1 column=cf1:age, timestamp=2020-11-25T06:47:30.715Z, value=14
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @param value
     * @throws IOException
     */
    public void increment(String tableName,String rowKey,String columnFamily,String column,long value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Increment increment = new Increment(Bytes.toBytes(rowKey));
        increment.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column),value);
        table.increment(increment);
    }

    /**
     * 删除某一列
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     */
    public void delete(String tableName,String rowKey,String columnFamily,String column) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        delete.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column));
        table.delete(delete);
    }
}

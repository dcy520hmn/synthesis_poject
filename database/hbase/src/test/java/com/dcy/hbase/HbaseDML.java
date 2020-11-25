package com.dcy.hbase;

import com.dcy.hbase.config.HbaseConfig;
import org.apache.hadoop.hbase.Cell;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseDML {

    private static Connection connection = null;
    private static Admin admin = null;

    private static final Logger logger = LoggerFactory.getLogger(HbaseDML.class);

    @Before
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

    @After
    public  void close(){
        try {
            admin.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDownMethod() throws IOException {
        //采用DDL中创建的表
//        insertOrUpdate("myTable","row1","cf1",new String[]{"name","age"},new String[]{"jack1",Long.toString(13L)});
//        append("myTable","row1","cf1","name","Wang");
//        increment("myTable","row1","cf1","age",2L);
//        selectOneRow("myTable","row1");
//        String name = getValue("myTable","row1","cf1","name");
        scanTable("myTable","row1","cf1","name");
    }

    /**
     * 增加
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
     * 获取一行数据
     * @param tableName
     * @param rowKey
     */
    public void selectOneRow(String tableName, String rowKey) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        byte[] value = result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("age"));
        System.out.println(Bytes.toLong(value));
    }

    /**
     * 获取某行某列数据
     * @param tableName
     * @param rowKey
     */
    public String getValue(String tableName, String rowKey,String columnFamily,String column) throws IOException {
        String value = "";
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column));
        Result result = table.get(get);
        List<Cell> ceList = result.listCells();
        if (ceList != null && ceList.size() > 0) {
            for (Cell cell : ceList) {
                value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
            }
        }
        return value;
    }

    /**
     * 扫描，类似与关系型数据库中的select,获得表中startRowKey所有的column值
     * @param tableName
     * @param startRowKey
     * @throws IOException
     */
    public void scanTable(String tableName, String startRowKey,String columnFamily,String column) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan(Bytes.toBytes(startRowKey));
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> iterator = resultScanner.iterator();
        while (iterator.hasNext()){
            Result next = iterator.next();
            String name = Bytes.toString(next.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes(column)));
            System.out.println(name);
        }
    }
}

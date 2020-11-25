package com.dcy.hbase;

import com.dcy.hbase.config.HbaseConfig;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseDDL {

    private static Connection connection = null;
    private static Admin admin = null;

    private static final Logger logger = LoggerFactory.getLogger(HbaseDDL.class);

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
        createTableOrOverWrite("myTable","cf1","cf2");
//        updateColumnFamily("myTable","cf1");
//        addColumnFamily("myTable","cf3");
//        deleteColumnFamily("myTable","cf3");
//        dropTable("myTable");
    }

    /**
     * 在新建表时，需要判断表是否存在，存在则进行：停用、删除、覆盖
     */
    public void createTableOrOverWrite(String tableName,String... columnFamilies) throws IOException {
        TableName name = TableName.valueOf(tableName);
        boolean exits = admin.tableExists(name);
        if(exits){//停用，删除
            admin.disableTable(name);
            admin.deleteTable(name);
        }
        //创建表格
        //创建table的describeBuilder
        TableDescriptorBuilder descriptorBuilder = TableDescriptorBuilder.newBuilder(name);
        //形成列族
        ArrayList<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
        for (String columnFamily : columnFamilies) {
            ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.newBuilder(columnFamily.getBytes()).build();
            columnFamilyDescriptors.add(columnFamilyDescriptor);
        }
        //将列族加入到describeBuilder中
        descriptorBuilder.setColumnFamilies(columnFamilyDescriptors);
        //生成tableDescriptor
        TableDescriptor tableDescriptor = descriptorBuilder.build();
        //创建表格
        admin.createTable(tableDescriptor);
    }

    /**
     * 删除表格
     */
    public void dropTable(String tableName) throws IOException {
        TableName name = TableName.valueOf(tableName);
        boolean exists = admin.tableExists(name);
        if(exists){
            admin.disableTable(name);
            admin.deleteTable(name);
        }
    }
    /**
     * 更改列族的属性
     * 设置最大版本数。同时也可以设置其它属性
     * @param tableName
     */
    public void updateColumnFamily(String tableName,String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        //创建列族的Builder
        ColumnFamilyDescriptorBuilder familyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(columnFamily.getBytes());
        familyDescriptorBuilder.setMaxVersions(5);
        //获得列族
        ColumnFamilyDescriptor columnFamilyDescriptor = familyDescriptorBuilder.build();
        //保存
        admin.modifyColumnFamily(name,columnFamilyDescriptor);
    }

    /**
     * 增加列族
     * @param tableName
     * @param columnFamily
     */
    public void addColumnFamily(String tableName,String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(columnFamily.getBytes());
        columnFamilyDescriptorBuilder.setMaxVersions(5);
        ColumnFamilyDescriptor columnFamilyDescriptor = columnFamilyDescriptorBuilder.build();
        admin.addColumnFamily(name,columnFamilyDescriptor);
    }

    /**
     * 删除列族
     * @param tableName
     * @param columnFamily
     */
    public void deleteColumnFamily(String tableName,String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        admin.disableTable(name);
        admin.deleteColumnFamily(name,columnFamily.getBytes());
    }


}

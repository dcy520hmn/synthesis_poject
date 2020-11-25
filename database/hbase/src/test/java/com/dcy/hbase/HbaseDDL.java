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
     * ���½���ʱ����Ҫ�жϱ��Ƿ���ڣ���������У�ͣ�á�ɾ��������
     */
    public void createTableOrOverWrite(String tableName,String... columnFamilies) throws IOException {
        TableName name = TableName.valueOf(tableName);
        boolean exits = admin.tableExists(name);
        if(exits){//ͣ�ã�ɾ��
            admin.disableTable(name);
            admin.deleteTable(name);
        }
        //�������
        //����table��describeBuilder
        TableDescriptorBuilder descriptorBuilder = TableDescriptorBuilder.newBuilder(name);
        //�γ�����
        ArrayList<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
        for (String columnFamily : columnFamilies) {
            ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.newBuilder(columnFamily.getBytes()).build();
            columnFamilyDescriptors.add(columnFamilyDescriptor);
        }
        //��������뵽describeBuilder��
        descriptorBuilder.setColumnFamilies(columnFamilyDescriptors);
        //����tableDescriptor
        TableDescriptor tableDescriptor = descriptorBuilder.build();
        //�������
        admin.createTable(tableDescriptor);
    }

    /**
     * ɾ�����
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
     * �������������
     * �������汾����ͬʱҲ����������������
     * @param tableName
     */
    public void updateColumnFamily(String tableName,String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        //���������Builder
        ColumnFamilyDescriptorBuilder familyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(columnFamily.getBytes());
        familyDescriptorBuilder.setMaxVersions(5);
        //�������
        ColumnFamilyDescriptor columnFamilyDescriptor = familyDescriptorBuilder.build();
        //����
        admin.modifyColumnFamily(name,columnFamilyDescriptor);
    }

    /**
     * ��������
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
     * ɾ������
     * @param tableName
     * @param columnFamily
     */
    public void deleteColumnFamily(String tableName,String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        admin.disableTable(name);
        admin.deleteColumnFamily(name,columnFamily.getBytes());
    }


}

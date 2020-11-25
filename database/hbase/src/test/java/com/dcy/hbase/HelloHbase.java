package com.dcy.hbase;

import com.dcy.hbase.config.HbaseConfig;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloHbase {

    private static Connection connection = null;
    private static Admin admin = null;

    private static final Logger logger = LoggerFactory.getLogger(HelloHbase.class);

    @Before
    public void init(){
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
     * ´´½¨table
     */
    @Test
    public void createTable(){
        TableName tableName  = TableName.valueOf("myTable");
        HTableDescriptor table = new HTableDescriptor(tableName);
        HColumnDescriptor cf = new HColumnDescriptor("cf");
        table.addFamily(cf);
        try {
            admin.createTable(table);
        } catch (IOException e) {
            try {
                admin.close();
                connection.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

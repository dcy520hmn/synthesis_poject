package com.dcy.hbase;

import com.dcy.hbase.config.HbaseConfig;
import com.dcy.hbase.util.HbaseDDL;
import com.dcy.hbase.util.HbaseDML;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseDMLTest {

    @Autowired
    private HbaseDML hbaseDML;
    @Autowired
    private HbaseDDL hbaseDDL;

    @Test
    public void testDownMethod() throws IOException {
        //采用DDL中创建的表
        hbaseDDL.createTableOrOverWrite("dmlTable","cf1");
        hbaseDML.insertOrUpdate("dmlTable","row1","cf1",new String[]{"name"},new String[]{"jack1"});
        hbaseDML.append("dmLTable","row1","cf1","name","Wang");
        hbaseDML.increment("dmLTable","row1","cf1","age",2L);
        hbaseDDL.dropTable("dmLTable");
    }

}

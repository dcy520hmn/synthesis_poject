package com.dcy.hbase;

import com.dcy.hbase.config.HbaseConfig;
import com.dcy.hbase.util.HbaseDDL;
import com.dcy.hbase.util.HbaseDML;
import com.dcy.hbase.util.HbaseDQL;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
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
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseDQLTest {

    @Autowired
    private HbaseDDL hbaseDDL;
    @Autowired
    private HbaseDML hbaseDML;
    @Autowired
    private HbaseDQL hbaseDQL;

    @Test
    public void testOfFilterReader() throws IOException {
//        hbaseDDL.createTableOrOverWrite("dqlTable","mycf");
        hbaseDML.insertOrUpdate("dqlTable","row1","mycf",new String[]{"name"},new String[]{"billyWangpaul"});
        hbaseDML.insertOrUpdate("dqlTable","row2","mycf",new String[]{"name"},new String[]{"sara"});
        hbaseDML.insertOrUpdate("dqlTable","row3","mycf",new String[]{"name"},new String[]{"chris"});
        hbaseDML.insertOrUpdate("dqlTable","row4","mycf",new String[]{"name"},new String[]{"helen"});
        hbaseDML.insertOrUpdate("dqlTable","row5","mycf",new String[]{"name"},new String[]{"andyWang"});
        hbaseDML.insertOrUpdate("dqlTable","row6","mycf",new String[]{"name"},new String[]{"Wang"});

        hbaseDML.insertOrUpdateAnyType("dqlTable","row1","mycf",
                new String[]{"age"},new Long[]{9L});
        hbaseDML.insertOrUpdateAnyType("dqlTable","row2","mycf",
                new String[]{"age"},new Long[]{22L});
        hbaseDML.insertOrUpdateAnyType("dqlTable","row3","mycf",
                new String[]{"age"},new Long[]{11L});
        hbaseDML.insertOrUpdateAnyType("dqlTable","row4","mycf",
                new String[]{"age"},new Long[]{16L});
        hbaseDML.insertOrUpdateAnyType("dqlTable","row5","mycf",
                new String[]{"age"},new Long[]{5L});
        hbaseDML.insertOrUpdateAnyType("dqlTable","row6","mycf",
                new String[]{"age"},new Long[]{66L});
    }


    @Test
    public void testApi() throws IOException {
//        //采用dmlTable中的数据
//        hbaseDQL.selectOneRow("dmlTable","row1");
//        String name =hbaseDQL.getValue("dmlTable","row1","cf1","name");
//        hbaseDQL.scanTable("dmlTable","row1","cf1","name");
//        //采用最新的数据
//        hbaseDQL.scanOfValueFilter("dqlTable","mycf","name","Wang");
//        hbaseDQL.scanOfColumnValueFilter("dqlTable","mycf","age",10L);
//        hbaseDQL.scanOfPageFilter("dqlTable","mycf",2L);
//        hbaseDQL.scanRowFilter("dqlTable","mycf","row2");
        hbaseDQL.scanMultiRowRangeFilter("dqlTable","mycf","row2","row3");
    }

}

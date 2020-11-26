package com.dcy.hbase;

import com.dcy.hbase.util.HbaseDDL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HbaseDDLTest {

    @Autowired
    private HbaseDDL hbaseDDL;

    @Test
    public void testDownMethod() throws IOException {
        hbaseDDL.createTableOrOverWrite("myTable","mycf");
        hbaseDDL.updateColumnFamily("myTable","cf1");
        hbaseDDL.addColumnFamily("myTable","cf3");
        hbaseDDL.deleteColumnFamily("myTable","cf3");
        hbaseDDL.dropTable("myTable");
    }



}

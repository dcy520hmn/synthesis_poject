package com.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.springboot.mapper.AccountMapper;
import com.springboot.mapper.TestDao;
import com.springboot.pojo.Account;
import com.springboot.pojo.TdPlanLeg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DataSourceTest {

    @Autowired
    private TestDao testDao;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private TdPlanLeg tdPlanLeg;

    @Test
    public void test1(){
        System.out.println(1);
    }
}

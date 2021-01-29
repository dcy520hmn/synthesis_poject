package com.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.springboot.mapper.AccountMapper;
import com.springboot.mapper.TestDao;
import com.springboot.service.impl.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestAop {

    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer();
    }
}

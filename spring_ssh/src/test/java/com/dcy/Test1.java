package com.dcy;


import com.dcy.pojo.Account;
import com.dcy.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Test1 {
    @Autowired
    AccountService accountService;

    @Test
    public void testAutoUpdate(){
        Account account = accountService.findAllAccount(1);
        account.setName("哈哈");
    }
}

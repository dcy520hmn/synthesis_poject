package com.dcy.springcloud.service;

import com.dcy.springcloud.mapper.AccountMapper;
import com.dcy.springcloud.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Account findAccountById(Integer id){
        //模拟超时
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }
}

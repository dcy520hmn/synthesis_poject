package com.dcy.service;

import com.dcy.mapper.AccountMapper;
import com.dcy.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;
    public Account findAllAccount(Integer accountId){
        Account account = accountMapper.findAccountById(accountId);
        return  account;
    }
}

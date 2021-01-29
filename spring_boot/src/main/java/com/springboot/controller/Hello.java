package com.springboot.controller;

import com.springboot.mapper.AccountMapper;
import com.springboot.mapper.TestDao;
import com.springboot.pojo.Account;
import com.springboot.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Hello {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/hello")
    public List<Account> hell(){
        List<Account> accountList = accountMapper.findAllAccount();
        return accountList;
    }

    @RequestMapping("/aopTest")
    public void aopTest(){
        accountService.transfer();
    }
}

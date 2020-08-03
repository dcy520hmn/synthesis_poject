package com.dcy.controller;

import com.dcy.pojo.Account;
import com.dcy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAccountById/{id}")
    public Account findAccountById(@PathVariable Integer id){
        Account account = accountService.findAccountById(id);
        return account;
    };
}

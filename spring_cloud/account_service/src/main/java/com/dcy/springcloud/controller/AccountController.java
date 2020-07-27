package com.dcy.springcloud.controller;

import com.dcy.springcloud.pojo.Account;
import com.dcy.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springcloudl/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAccountById/{id}")
    public Account findAccountById(@PathVariable Integer id){
          return accountService.findAccountById(id);
    }
}

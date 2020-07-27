package com.dcy.springcloud.controller;

import com.dcy.springcloud.pojo.Account;
import com.dcy.springcloud.service.AccountClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountClientController {

    @Autowired
    private AccountClientService accountClientService;

    @RequestMapping("/findAccountById/{id}")
    public Account findAccountById(@PathVariable  Integer id){
        return  accountClientService.findAccountById(id);
    }

}

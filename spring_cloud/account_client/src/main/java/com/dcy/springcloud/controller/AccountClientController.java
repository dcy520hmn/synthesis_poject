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

    @RequestMapping("/findAccountById/noRibon/{id}")
    public Account findAccountByIdNoRibbon(@PathVariable  Integer id){
        return  accountClientService.findAccountByIdNoRibbon(id);
    }

    @RequestMapping("/findAccountById/ribbon/{id}")
    public Account findAccountByIdRibbon(@PathVariable  Integer id){
        return  accountClientService.findAccountByIdRibbon(id);
    }

    @RequestMapping("/findAccountById/hystrix/{id}")
    public String findAccountByIdRibbonHystrix(@PathVariable  Integer id){
        return  accountClientService.findAccountByIdHystrix(id);
    }

    @RequestMapping("/findAccountById/feign/{id}")
    public Account findAccountByIdFegin(@PathVariable Integer id){
        return accountClientService.findAccountByIdFeign(id);
    }
}

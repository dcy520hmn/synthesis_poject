package com.dcy.springcloud.service;

import com.dcy.springcloud.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountClientService {

    @Autowired
    private RestTemplate restTemplate;

    public Account findAccountById(Integer id){
       return restTemplate.getForObject("http://localhost:8081/springcloudl/account/findAccountById/"+id,Account.class);
    }
}

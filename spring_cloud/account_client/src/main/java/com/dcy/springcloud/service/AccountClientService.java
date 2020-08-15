package com.dcy.springcloud.service;

import com.dcy.springcloud.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccountClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息


    public Account findAccountById(Integer id){
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("account-server");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/springcloudl/account/findAccountById/"+id;
        return restTemplate.getForObject(baseUrl,Account.class);
    }
}

package com.dcy.springcloud.service;

import com.dcy.springcloud.feginClient.AccountFeignClient;
import com.dcy.springcloud.pojo.Account;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@DefaultProperties(defaultFallback = "findAccountByIdHystrixError")
public class AccountClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

    /**
     * 未使用负载均衡的情况
     * @param id
     * @return
     * 去掉restTemplate得@LoadBalance
     */
    public Account findAccountByIdNoRibbon(Integer id){
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("account-server");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/springcloudl/account/findAccountById/"+id;
        return restTemplate.getForObject(baseUrl,Account.class);
    }

    /**
     * 使用负载均衡
     * @param id
     * @return
     * 在restTemplate加上@LoadBalance
     */
    public Account findAccountByIdRibbon(Integer id){
        String baseUrl = "http://ACCOUNT-SERVER/springcloudl/account/findAccountById/"+id;
        return restTemplate.getForObject(baseUrl,Account.class);
    }

    /**
     * 加上hystrix
     * @param id
     * 错误处理方法得返回值必须与正确的返回值一致
     * @return
     */
    @HystrixCommand
    public String findAccountByIdHystrix(Integer id){
        String baseUrl = "http://ACCOUNT-SERVER/springcloudl/account/findAccountById/"+id;
        return restTemplate.getForObject(baseUrl,String.class);
    }

    public Account findAccountByIdFeign(Integer id){
       return accountFeignClient.findAccountByIdFegin(id);
    }
    public String findAccountByIdHystrixError(){
        return "system busy";
    }
}

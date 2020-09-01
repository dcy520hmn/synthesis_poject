package com.dcy.springcloud.feginClient;

import com.dcy.springcloud.pojo.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ACCOUNT-SERVER")
public interface AccountFeignClient {

    @GetMapping("/springcloudl/account/findAccountById/{id}")
    Account findAccountByIdFegin(@PathVariable("id") Integer id);
}

package com.dcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableEurekaClient  等同于springCloudApplication
//@EnableCircuitBreaker
@SpringCloudApplication
@EnableFeignClients
public class AccountClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountClientApplication.class);
    }
}

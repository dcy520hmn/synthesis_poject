package com.springboot.config.beanDemo;

import com.springboot.pojo.Account;
import com.springboot.pojo.TdPlanLeg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 主要验证，@Bean的方法名就是bean的Id。验证结果成立。测试代码在
 * com/springboot/AopTest.java
 */
@Configuration
public class BeanDemo {

    @Bean
    public Account account1(){
        Account account = new Account();
        account.setId(1);
        return account;
    }

    @Bean
    public Account account2(){
        Account account = new Account();
        account.setId(2);
        return account;
    }

    @Bean
    public TdPlanLeg tdPlanLeg(Account account1,Account account2){
        TdPlanLeg tdPlanLeg = new TdPlanLeg();
        Integer id1 = account1.getId();
        Integer id2 = account2.getId();
        System.out.println(id1+","+id2);
        return tdPlanLeg;
    }
}

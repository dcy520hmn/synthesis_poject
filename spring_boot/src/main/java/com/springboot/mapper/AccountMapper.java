package com.springboot.mapper;

import com.springboot.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountMapper {
     List<Account> findAllAccount();
}

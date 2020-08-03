package com.dcy.mapper;

import com.dcy.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountMapper {
    Account findAccountById(@Param("id") Integer id);
}

package com.dcy.springcloud.mapper;

import com.dcy.springcloud.pojo.Account;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AccountMapper extends Mapper<Account> {
}

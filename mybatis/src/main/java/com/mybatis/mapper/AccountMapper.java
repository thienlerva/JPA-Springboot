package com.mybatis.mapper;

import com.mybatis.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> findAll();

    Integer insert(Account account);
}

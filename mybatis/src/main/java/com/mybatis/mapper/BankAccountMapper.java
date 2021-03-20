package com.mybatis.mapper;

import com.mybatis.model.BankAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankAccountMapper {
    Integer insert(BankAccount bankAccount);
    List<BankAccount> findAll();

    List<BankAccount> findByUserId(Integer id);
}

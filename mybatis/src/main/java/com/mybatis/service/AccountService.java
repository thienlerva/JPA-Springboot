package com.mybatis.service;

import com.mybatis.mapper.AccountMapper;
import com.mybatis.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    public Integer insert(Account account) {
        return accountMapper.insert(account);
    }
}

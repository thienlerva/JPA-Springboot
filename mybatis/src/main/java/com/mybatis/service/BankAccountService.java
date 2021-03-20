package com.mybatis.service;

import com.mybatis.mapper.BankAccountMapper;
import com.mybatis.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountMapper bankAccountMapper;

    public Integer insert(BankAccount bankAccount) {
        return bankAccountMapper.insert(bankAccount);
    }
    public List<BankAccount> findAll() {
        return bankAccountMapper.findAll();
    }

    public List<BankAccount> findByUserId(Integer id) {
        return bankAccountMapper.findByUserId(id);

//        if(bankAccounts==null) {
//            ResponseEntity<BankAccount> bankAccountResponseEntity = ResponseEntity<>
//        }
    }
}

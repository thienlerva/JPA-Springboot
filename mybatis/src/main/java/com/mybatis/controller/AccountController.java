package com.mybatis.controller;

import com.mybatis.model.Account;
import com.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/all")
    List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping("/account/create")
    Integer create(@RequestBody Account account) {
        return accountService.insert(account);
    }
}

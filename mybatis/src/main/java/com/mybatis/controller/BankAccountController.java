package com.mybatis.controller;

import com.mybatis.model.BankAccount;
import com.mybatis.service.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@CrossOrigin("*")
@RequestMapping("/bankaccount")
@RestController
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @PostMapping("/create")
    ResponseEntity<BankAccount> insert(@RequestBody BankAccount bankAccount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        bankAccount.setCreateTs(localDateTime);
        log.info(" {}", bankAccount);

        if(bankAccountService.insert(bankAccount) != null) {
            return new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    List<BankAccount> findAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/findByUserId/{id}")
    List<BankAccount> findByUseId(@PathVariable Integer id) {
        return  bankAccountService.findByUserId(id);
    }
}

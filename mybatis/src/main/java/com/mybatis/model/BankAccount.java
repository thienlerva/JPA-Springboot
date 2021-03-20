package com.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankAccount {
    Integer id;
    Integer typeId;
    Integer userId;
    Double balance;
    LocalDateTime createTs;
}

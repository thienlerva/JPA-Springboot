package com.mybatis.model;

import lombok.Data;

@Data
public class User {

    Integer id;
    String firstName;
    String lastName;
    String username;
    String password;
}

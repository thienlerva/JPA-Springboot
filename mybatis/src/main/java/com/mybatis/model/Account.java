package com.mybatis.model;

import lombok.Data;

@Data
public class Account {

    Integer id;
    Type type;

    public boolean checkType(String str) {


        return str.equals(Type.CD);
    }
}

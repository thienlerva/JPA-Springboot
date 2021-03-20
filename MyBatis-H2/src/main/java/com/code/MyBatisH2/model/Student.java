package com.code.MyBatisH2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
public class Student {

    Integer id;

    String name;
    String phone;
    String email;
    Integer courseId;
}

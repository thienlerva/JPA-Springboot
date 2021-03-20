package com.mybatis.model;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import lombok.Data;

@Data
//@Entity
public class Student {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String phone;
    String email;
    Integer courseId;
}

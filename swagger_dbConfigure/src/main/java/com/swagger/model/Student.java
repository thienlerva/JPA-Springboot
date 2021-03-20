package com.swagger.model;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import lombok.Data;

@Data
public class Student {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String name;
    String phone;
    String email;

}

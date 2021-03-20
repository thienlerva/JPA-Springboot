package com.code.MyBatisH2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class StudentCourse {

    @Id
    Integer id;
    String name;
    String instructor;
}

package com.code.MyBatisH2.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //@Column(name = "course_name")
    String name;
    String instructor;
}

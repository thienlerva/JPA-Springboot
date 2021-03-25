package com.example.ProductAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @Column(name = "student_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "student_name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

}

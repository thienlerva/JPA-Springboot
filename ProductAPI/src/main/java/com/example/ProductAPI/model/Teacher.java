package com.example.ProductAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "TEACHERS")
public class Teacher {

    @Id
    @Column(name = "teacher_id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;

    @Column(name = "teacher_name")
    private String name;

}

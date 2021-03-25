package com.example.ProductAPI.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "SUBJECTS")
public class Subject {

    @Id
    @Column(name = "subject_id")
    Long id;

    @Column(name = "subject_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "STUDENTENROLLED",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    public void setEnrolledStudents(Student student) {
        enrolledStudents.add(student);
    }
}
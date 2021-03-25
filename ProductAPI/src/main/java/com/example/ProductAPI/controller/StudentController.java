package com.example.ProductAPI.controller;

import com.example.ProductAPI.model.Student;
import com.example.ProductAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}

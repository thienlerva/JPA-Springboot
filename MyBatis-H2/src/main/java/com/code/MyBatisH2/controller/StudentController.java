package com.code.MyBatisH2.controller;

import com.code.MyBatisH2.mapper.StudentMapper;
import com.code.MyBatisH2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/all")
    public List<Student> findAll() {
        Student student = new Student();
        return studentMapper.findAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id)
    {
        return studentMapper.findById(id);
    }

    @PostMapping("/create")
    public int create(@RequestBody Student student) {
        return studentMapper.insert(student);
    }
}

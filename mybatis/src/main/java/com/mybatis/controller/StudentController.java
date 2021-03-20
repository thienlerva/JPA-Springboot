package com.mybatis.controller;

import com.mybatis.model.Student;
import com.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/all")
    public List<Student> findAll() {
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

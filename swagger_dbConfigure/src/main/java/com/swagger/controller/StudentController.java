package com.swagger.controller;

import com.swagger.Service.CAMPSBatchService;
import com.swagger.configure.DBQueryConfig;
import com.swagger.mapper.StudentMapper;
import com.swagger.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    CAMPSBatchService campsBatchService;
    @Autowired
    DBQueryConfig dbQueryConfig;

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
    public List<Student> findById(@PathVariable String id)
    {
        return studentMapper.findById(id);
    }

//    @PostMapping("/create")
//    public int create(@RequestBody Student student) {
//        return studentMapper.insert(student);
//    }
}

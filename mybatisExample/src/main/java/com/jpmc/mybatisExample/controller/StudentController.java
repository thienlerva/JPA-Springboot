package com.jpmc.mybatisExample.controller;

import com.jpmc.mybatisExample.mapper.StudentRepository;
import com.jpmc.mybatisExample.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable long id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @PostMapping("/create")
    public int create(@RequestBody Student student) {
        return studentRepository.insert(student);
    }

    @PutMapping("/update")
    public int update(@RequestBody Student student) {
        return studentRepository.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable long id) {
        return studentRepository.deleteById(id);
    }


}

package com.mybatis.controller;

import com.mybatis.mapper.StudentCourseMapper;
import com.mybatis.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCourseController {

    @Autowired
    StudentCourseMapper studentCourseMapper;

    @GetMapping("/join")
    public List<StudentCourse> findAll() {
        return studentCourseMapper.findAll();
    }
}

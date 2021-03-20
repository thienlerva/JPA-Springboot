package com.code.MyBatisH2.controller;

import com.code.MyBatisH2.mapper.StudentCourseMapper;
import com.code.MyBatisH2.model.StudentCourse;
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

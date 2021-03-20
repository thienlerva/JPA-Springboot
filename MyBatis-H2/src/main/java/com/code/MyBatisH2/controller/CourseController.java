package com.code.MyBatisH2.controller;

import com.code.MyBatisH2.mapper.CourseMapper;
import com.code.MyBatisH2.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/course/all")
    public List<Course> findAll() {
        return courseMapper.findAll();
    }
}

package com.mybatis.mapper;

import com.mybatis.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(Integer id);
    int insert(Course course);
}

package com.code.MyBatisH2.mapper;

import com.code.MyBatisH2.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(Integer id);
    int insert(Course course);
}

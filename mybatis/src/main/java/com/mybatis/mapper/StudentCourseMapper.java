package com.mybatis.mapper;

import com.mybatis.model.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    List<StudentCourse> findAll();
}

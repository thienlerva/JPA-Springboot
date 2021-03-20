package com.code.MyBatisH2.mapper;

import com.code.MyBatisH2.model.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    List<StudentCourse> findAll();
}
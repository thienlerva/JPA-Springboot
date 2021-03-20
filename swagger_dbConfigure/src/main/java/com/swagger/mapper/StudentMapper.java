package com.swagger.mapper;

import com.swagger.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> findAll();

    List<Student> findById(@Param("id") String id);

    int insert(Student student);
}

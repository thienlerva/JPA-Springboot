package com.code.MyBatisH2.mapper;

import com.code.MyBatisH2.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> findAll();

    Student findById(Integer id);

    int insert(Student student);
}

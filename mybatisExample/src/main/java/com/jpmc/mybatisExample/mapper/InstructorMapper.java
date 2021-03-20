package com.jpmc.mybatisExample.mapper;

import com.jpmc.mybatisExample.models.Instructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstructorMapper {

    void insertInstructor(Instructor instructor);
    Instructor findInstructorById(Integer id);
    List<Instructor> findAllInstructors();
}

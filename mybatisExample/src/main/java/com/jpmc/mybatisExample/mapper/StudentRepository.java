package com.jpmc.mybatisExample.mapper;

import com.jpmc.mybatisExample.models.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("select * from student where id = #{id}")
    Student findById(long id);

    @Select("select * from student")
     List<Student> findAll();

    @Delete("delete from student where id = #{id}")
    int deleteById(long id);

    @Insert("insert into student values (#{id}, #{name}, #{passport})")
    int insert(Student student);

    @Update("update student set name = #{name}, passport = #{passport} where id = #{id}")
    int update(Student student);
}

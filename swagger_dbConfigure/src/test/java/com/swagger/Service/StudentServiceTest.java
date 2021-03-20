package com.swagger.Service;

import com.swagger.configure.EmbeddedDBTestConfiguration;
import com.swagger.controller.StudentController;
import com.swagger.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = EmbeddedDBTestConfiguration.class, properties = "spring.main.allow-bean-definition-overriding=true")
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    StudentService classUnderTest;

    @Autowired
    StudentController studentController;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void insertNewRecord() {

        List<Student> students = studentController.findAll();
        System.out.println(students);
    }

}
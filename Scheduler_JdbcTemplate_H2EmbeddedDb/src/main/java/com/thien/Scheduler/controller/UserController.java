package com.thien.Scheduler.controller;

import com.thien.Scheduler.mapper.UserMapper;
import com.thien.Scheduler.model.User;
import com.thien.Scheduler.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/size")
    public String userSize() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM USER", Integer.class).toString();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(Integer id) {
        String query = "DELETE FROM USER WHERE USER_ID = 979";
        jdbcTemplate.update(query);
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM USER", Integer.class).toString();
    }

    @PostMapping("/find/{id}")
    public User findById(@PathVariable Integer id) {

        System.out.println("More reading: https://github.com/kishanjavatrainer/NamedParameterJdbcTemplateUsingAnnotation" +
                "/blob/master/NamedParameterJdbcTemplateUsingAnnotation/src/com/infotech/dao/impl/EmployeeDAOImpl.java");
        String sql = "SELECT * FROM USER WHERE USER_ID=:userId";

        MapSqlParameterSource inputMap = new MapSqlParameterSource();

        inputMap.addValue("userId", id);

        User user = namedParameterJdbcTemplate.queryForObject(sql, inputMap, new UserRowMapper());
        return user;

    }

    @GetMapping("/all")
    public List<User> findAll() {
        String sql = "SELECT * FROM USER";
        return namedParameterJdbcTemplate.query(sql, new UserRowMapper());
    }
}

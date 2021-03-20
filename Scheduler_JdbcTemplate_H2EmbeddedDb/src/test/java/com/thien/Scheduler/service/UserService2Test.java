package com.thien.Scheduler.service;

import com.thien.Scheduler.SchedulerApplication;
import com.thien.Scheduler.mapper.UserMapper;
import com.thien.Scheduler.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchedulerApplication.class)
public class UserService2Test {

    @Autowired
    UserMapper userMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void shouldGetUsers() {
        User user1 = new User(1, "Thien");
        User user2 = new User(2,"Nga");

        List<User> users = Arrays.asList(user1, user2);
        //assertThat(3, is(userMapper.findAll().size()));
        assertThat(users, is(userMapper.findAll()));
    }

    @Test
    public void shouldInsertUser() {
        String query = "INSERT INTO USER VALUES (3, 'Vy')";
        jdbcTemplate.update(query);
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void shouldDelete() {
//        String query = "DELETE FROM USER WHERE USER_ID = 1";
//        jdbcTemplate.update(query);
        Integer result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM USER", Integer.class);
        //List<User> users = userMapper.findAll();
        System.out.println(result);
    }

}
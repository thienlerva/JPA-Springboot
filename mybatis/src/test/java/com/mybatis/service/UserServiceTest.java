package com.mybatis.service;

import com.mybatis.MybatisApplication;
import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void shouldVerifyLogin() {
        User user1 = new User();
        user1.setId(81);
        user1.setFirstName("Dan");
        user1.setLastName("Miller");
        user1.setUsername("Danmiller");
        user1.setPassword("millerdan");

        User user2 = new User();
        user2.setId(81);
        user2.setFirstName("Dan");
        user2.setLastName("Miller");
        user2.setUsername("Danmiller");
        user2.setPassword("millerdan");
        when(userMapper.verifyLogin(user1)).thenReturn(user2);
        //asserThat(userService.verifyLogin(user1), instanceOf(user2));
        //assertEquals()
    }

    @Test
    public void shouldUserList() {
        assertThat(userMapper.findAll().size(), is(13));
    }

    @Test
    public void checkSize() {
        assertThat(userService.userSize(), is(12));
    }
}
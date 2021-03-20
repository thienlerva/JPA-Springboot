package com.thien.Scheduler.service;

import com.thien.Scheduler.mapper.UserMapper;
import com.thien.Scheduler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService2 {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }
}

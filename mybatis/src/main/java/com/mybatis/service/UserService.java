package com.mybatis.service;

import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    LocalDateTime localDateTime;

    public List<User> sortByLastName() {
        List<User> userList = userMapper.findAll();
        log.info("Local date and time: {}", localDateTime.now());
        log.info("List of user {}", userList);
        return userList.stream().sorted(Comparator.comparing(User::getLastName)).collect(Collectors.toList());
    }

    public long userSize() {
        List<User> userList = userMapper.findAll();
        return userList.stream().count();
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    public Integer update(User user) {
        return userMapper.update(user);
    }

    public User verifyLogin(User user) {
        return userMapper.verifyLogin(user);
    }

    public User validateUsername(User user) {
        return userMapper.validateUsername(user);
    }

    public User findUserId(User user) { return userMapper.findUserId(user); }
}

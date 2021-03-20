package com.mybatis.mapper;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    Integer insert(User user);

    Integer delete(Integer id);

    Integer update(User user);

    User verifyLogin(User user);

    User validateUsername(User user);

    User findUserId(User user);
}

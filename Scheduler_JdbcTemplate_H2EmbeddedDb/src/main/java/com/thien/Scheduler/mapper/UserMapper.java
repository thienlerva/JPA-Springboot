package com.thien.Scheduler.mapper;

import com.thien.Scheduler.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
    void insert(User user);
}

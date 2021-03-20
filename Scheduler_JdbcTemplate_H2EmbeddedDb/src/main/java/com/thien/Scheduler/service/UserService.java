package com.thien.Scheduler.service;

import com.thien.Scheduler.mapper.UserMapper;
import com.thien.Scheduler.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    // schedule a job to add object in DB every 5 secs
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setId(new Random().nextInt(1000));
        user.setName("user" + user.getId());
        userMapper.insert(user);
        log.info("Add service call in {}", new Date().toString());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<User> users = userMapper.findAll();
        log.info("Fetch service call in {}", new Date().toString());
        log.info("Number of record fetched {}", users.size());
        log.info("Users: {}", users);
    }
}

package com.mybatis.controller;

import com.mybatis.model.User;
import com.mybatis.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/sortByName")
    List<User> sortByName() {
        return  userService.sortByLastName();
    }

    @GetMapping("/count")
    Long countUser() {
        return userService.userSize();
    }

    @GetMapping("/all")
    List<User> findAll() {

        return userService.findAll();
    }

    @PostMapping("/create")
    Integer insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @DeleteMapping("/delete/{id}")
    Integer delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PutMapping("/update")
    Integer update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/login")
    ResponseEntity<User> verifyLogin(@RequestBody User user) {
        User user1= userService.verifyLogin(user);

        if(user1 == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        }
    }

    @PostMapping("/validate")
    ResponseEntity<User> validateUsername(@RequestBody User user) {
        User user1 = userService.validateUsername(user);

        if(user1 == null) {
            return new ResponseEntity<>((HttpStatus.ACCEPTED));
        } else {
            return new ResponseEntity<>(user1, HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/findUserId")
    ResponseEntity<User> findUserId(@RequestBody User user) {

        User user1 = userService.findUserId(user);

        if(user1 == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user1, HttpStatus.ACCEPTED);
        }
    }

}

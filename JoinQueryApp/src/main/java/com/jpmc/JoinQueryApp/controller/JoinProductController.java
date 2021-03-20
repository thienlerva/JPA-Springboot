package com.jpmc.JoinQueryApp.controller;

import com.jpmc.JoinQueryApp.mapper.JoinProductMapper;
import com.jpmc.JoinQueryApp.model.JoinProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/join-product")
public class JoinProductController {

    @Autowired
    JoinProductMapper joinProductMapper;

    @GetMapping("/all")
    List<JoinProduct> findAll() {
        return joinProductMapper.findAll();
    }

    @GetMapping("/name")
    List<JoinProduct> getCustomerName() {
        return joinProductMapper.getCustomerName();
    }
}

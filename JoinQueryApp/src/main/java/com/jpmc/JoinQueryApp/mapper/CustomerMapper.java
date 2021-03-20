package com.jpmc.JoinQueryApp.mapper;

import com.jpmc.JoinQueryApp.model.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customer> findAll();

    Integer createCustomer(Customer customer);
}

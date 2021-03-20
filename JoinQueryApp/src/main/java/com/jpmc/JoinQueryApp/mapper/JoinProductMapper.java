package com.jpmc.JoinQueryApp.mapper;

import com.jpmc.JoinQueryApp.model.JoinProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinProductMapper {

    List<JoinProduct> findAll();

    List<JoinProduct> getCustomerName();
}

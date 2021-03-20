package com.jpmc.JoinQueryApp.mapper;

import com.jpmc.JoinQueryApp.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> findAll();

    List<Product> getProductList(@Param("productIds")Collection<BigInteger> productIds);

    Product findById(Integer id);

    Integer insert(Product product);
}

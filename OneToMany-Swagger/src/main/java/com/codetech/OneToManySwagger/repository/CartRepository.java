package com.codetech.OneToManySwagger.repository;

import com.codetech.OneToManySwagger.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}

package com.codetech.OneToManySwagger.repository;

import com.codetech.OneToManySwagger.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}

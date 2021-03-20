package com.codetech.OneToManySwagger.service;

import com.codetech.OneToManySwagger.model.Item;
import com.codetech.OneToManySwagger.model.exception.ItemNotFoundException;
import com.codetech.OneToManySwagger.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getItems() {
        return StreamSupport
                .stream(itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);
        return item;
    }

    @Transactional //to persist
    public Item editItem(Long id, Item item) {
        Item itemToEdit = getItem(id);
        itemToEdit.setSerialNumber(item.getSerialNumber());
        return itemToEdit;
    }
}

package com.example.ProductAPI.controller;

import com.example.ProductAPI.model.Item;
import com.example.ProductAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item itemToAdd = itemService.addItem(item);
        return new ResponseEntity<>(itemToAdd, HttpStatus.OK);
    }
}

package com.example.ProductAPI.controller;

import com.example.ProductAPI.model.Cart;
import com.example.ProductAPI.model.Item;
import com.example.ProductAPI.repository.CartRepository;
import com.example.ProductAPI.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getCarts() {
        List<Cart> carts = cartService.getCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart cardToAdd = cartService.addCart(cart);
        return new ResponseEntity<>(cardToAdd, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Cart, List<Item>>> getCartWithItems(@PathVariable final Long id) {
        Map<Cart, List<Item>> cartListMap = cartService.getCartWithItems(id);
        return new ResponseEntity<>(cartListMap, HttpStatus.OK);
    }
}

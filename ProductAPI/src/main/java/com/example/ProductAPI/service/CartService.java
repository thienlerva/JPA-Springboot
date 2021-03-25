package com.example.ProductAPI.service;

import com.example.ProductAPI.model.Cart;
import com.example.ProductAPI.model.Item;
import com.example.ProductAPI.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemService itemService;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Map<Cart, List<Item>> getCartWithItems(Long id) {
        List<Item> items = itemService.getItems();
        Cart cart = cartRepository.findById(id).get();
        List<Item> sortedItems = items.stream().filter(item -> item.getCart().getId().equals(id)).collect(Collectors.toList());
        Map<Cart, List<Item>> result = new HashMap<>();
        result.put(cart, sortedItems);
        return result;
    }
}

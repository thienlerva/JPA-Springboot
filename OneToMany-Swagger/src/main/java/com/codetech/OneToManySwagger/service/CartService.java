package com.codetech.OneToManySwagger.service;

import com.codetech.OneToManySwagger.model.Cart;
import com.codetech.OneToManySwagger.model.Item;
import com.codetech.OneToManySwagger.model.exception.CartNotFoundException;
import com.codetech.OneToManySwagger.model.exception.ItemIsAlreadyAssignedException;
import com.codetech.OneToManySwagger.repository.CartRepository;
import com.codetech.OneToManySwagger.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts() {
        return StreamSupport
                .stream(cartRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new CartNotFoundException(id));
    }

    public Cart deleteCart(Long id) {
        Cart cart = getCart(id);
        cartRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Cart editCart(Long id, Cart cart) {
        Cart cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());
        return cartToEdit;
    }

    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);

        if (Objects.nonNull(item.getCart())) {
            throw new ItemIsAlreadyAssignedException(itemId, item.getCart().getId());
        }
        cart.addItem(item);
        item.setCart(cart);
        return cart;
    }

    @Transactional
    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }

}

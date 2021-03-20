package com.codetech.OneToManySwagger.model;

import com.codetech.OneToManySwagger.model.dto.CartDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    List<Item> items = new ArrayList<>();

    public Cart() {}

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public static Cart from(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setName(cartDto.getName());
        return cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.example.ProductAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "ITEMS")
public class Item {

    @Id
    @Column(name = "item_id")
    Long id;

    @Column(name = "serial_number")
    String serialNumber;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    Cart cart;

    public Item() {}

    public Item(String serialNumber, Cart cart) {
        this.serialNumber = serialNumber;
        this.cart = cart;
    }
}

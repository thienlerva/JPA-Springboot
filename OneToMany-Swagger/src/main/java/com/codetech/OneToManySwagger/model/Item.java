package com.codetech.OneToManySwagger.model;

import com.codetech.OneToManySwagger.model.dto.ItemDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String serialNumber;

    @ManyToOne
    private Cart cart;

    public Item() {}

    public static Item from(ItemDto itemDto) {
        Item item = new Item();
        item.setSerialNumber(itemDto.getSerialNumber());
        return item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

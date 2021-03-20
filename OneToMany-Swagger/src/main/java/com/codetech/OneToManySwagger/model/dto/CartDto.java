package com.codetech.OneToManySwagger.model.dto;

import com.codetech.OneToManySwagger.model.Cart;
import com.codetech.OneToManySwagger.model.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {

    Long id;
    String name;
    List<ItemDto> itemsDto = new ArrayList<>();

    public static CartDto from(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setName(cart.getName());
        cartDto.setItemsDto(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));
        return cartDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemDto> getItemsDto() {
        return itemsDto;
    }

    public void setItemsDto(List<ItemDto> itemsDto) {
        this.itemsDto = itemsDto;
    }
}

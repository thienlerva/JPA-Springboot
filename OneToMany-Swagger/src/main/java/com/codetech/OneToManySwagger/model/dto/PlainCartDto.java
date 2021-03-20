package com.codetech.OneToManySwagger.model.dto;

import com.codetech.OneToManySwagger.model.Cart;

public class PlainCartDto {

    Long id;
    String name;

    public static PlainCartDto from(Cart cart) {
        PlainCartDto plainCartDto = new PlainCartDto();
        plainCartDto.setId(cart.getId());
        plainCartDto.setName(cart.getName());
        return plainCartDto;
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
}

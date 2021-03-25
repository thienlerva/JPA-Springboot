package com.example.ProductAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @Column(name = "cart_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column( name = "cart_name")
    String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Item> items = new ArrayList<>();

}

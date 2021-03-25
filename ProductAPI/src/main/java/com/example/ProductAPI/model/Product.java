package com.example.ProductAPI.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

//@Data
@Entity
@Table(name="Products")
@ToString
@Getter
@Setter
public class Product {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="product_name")
    String name;
    String material;
    double price;

    @Column(name="create_at")
    String created;

    String description;

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    Image image;


}

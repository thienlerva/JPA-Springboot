package com.example.ProductAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Images")
public class Image {

    @Id
    @Column(name="image_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="create_at")
    String created;

    @Column(name="image_url")
    String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Product> products = new ArrayList<>();


}

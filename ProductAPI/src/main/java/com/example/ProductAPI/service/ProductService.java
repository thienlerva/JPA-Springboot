package com.example.ProductAPI.service;

import com.example.ProductAPI.model.Image;
import com.example.ProductAPI.model.Product;
import com.example.ProductAPI.repository.ImageRepository;
import com.example.ProductAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = new Product();
        return productOptional.orElse(product);
    }

//    public Map<String, List<Image>> getProductImages(Long productId) {
//        List<Image> images = imageRepository.findAll();
//
//        List<Image> requestImages = images.stream().filter(i -> i.().equals(productId))
//                .collect(Collectors.toList());
//
//        Map<String, List<Image>> imageMap = new HashMap<>();
//        imageMap.put("image", requestImages);
//        return imageMap;
//    }

}

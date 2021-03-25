package com.example.ProductAPI.controller;

import com.example.ProductAPI.model.Image;
import com.example.ProductAPI.model.Product;
import com.example.ProductAPI.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/message")
    String getMessage() {
        return "Hello world";
    }

    @GetMapping("/all")
    ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @GetMapping("query/{id}")
//    ResponseEntity<Map<Product, Map<String, List<Image>>>> queryProduct(@PathVariable Long id) {
//        Map<String, List<Image>> imageMap = productService.getProductImages(id);
//        Product product = productService.findById(id);
//        Map<Product, Map<String, List<Image>>> result = new HashMap<>();
//        result.put(product, imageMap);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}

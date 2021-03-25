package com.example.ProductAPI.controller;

import com.example.ProductAPI.model.Image;
import com.example.ProductAPI.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping
    ResponseEntity<List<Image>> getImages() {
        List<Image> images = imageRepository.findAll();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}

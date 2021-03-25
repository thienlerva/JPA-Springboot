package com.example.ProductAPI;

import com.example.ProductAPI.model.Cart;
import com.example.ProductAPI.model.Item;
import com.example.ProductAPI.model.Product;
import com.example.ProductAPI.repository.CartRepository;
import com.example.ProductAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProductApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setId(Long.valueOf(1));
//		product.setName("Canvas");
//		product.setMaterial("fabric");
//		product.setPrice(219.00);
//
//		Date date = new Date();
//		Timestamp ts=new Timestamp(date.getTime());
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		product.setCreated(ts.toString());
//		System.out.println(product);
//
//		productRepository.save(product);
	}
}

package com.jpmc.JoinQueryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Product {

    BigInteger productId;
    String productName;
    BigDecimal price;
    BigInteger customerId;

    public Product(BigInteger productId, String productName, BigDecimal price, BigInteger customerId) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.customerId = customerId;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }
}

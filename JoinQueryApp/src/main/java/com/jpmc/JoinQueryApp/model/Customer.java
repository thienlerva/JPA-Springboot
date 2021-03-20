package com.jpmc.JoinQueryApp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Customer {

    Integer customerId;
    String customerName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

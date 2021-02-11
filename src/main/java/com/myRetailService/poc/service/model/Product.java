package com.myRetailService.poc.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document
public class Product {
    @Id
    private String id;
    private CurrentPrice current_price;

    public Product(String id, CurrentPrice current_price) {
        this.current_price = current_price;
        this.id = id;
    }
    public CurrentPrice getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

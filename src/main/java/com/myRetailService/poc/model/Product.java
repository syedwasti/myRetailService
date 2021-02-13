package com.myRetailService.poc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;
    private String pName;
    private CurrentPrice current_price;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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

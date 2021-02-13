package com.myRetailService.poc.service;

import com.myRetailService.poc.model.CurrentPrice;
import com.myRetailService.poc.model.Product;
import org.springframework.stereotype.Component;

@Component
public class RedskyService {

    public Product getRedskyProduct(String id) {
        Product product = new Product();
        product.setpName("The Big Lebowski (Blu-ray) (Widescreen)");
        product.setId("13860428");
        return product;
    }
}

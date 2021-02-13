package com.myRetailService.poc.controller;

import com.myRetailService.poc.exception.ProductNotFoundException;
import com.myRetailService.poc.model.Product;
import com.myRetailService.poc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/v1/products/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable String id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @PutMapping("/api/v1/products/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.noContent().build();
    }

}

package com.myRetailService.poc.controller;

import com.myRetailService.poc.model.Product;
import com.myRetailService.poc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value="/api/v1/products", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value="/api/v1/products/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value="/api/v1/products/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok("Record Successfully updated for ID: " + id);
    }

}

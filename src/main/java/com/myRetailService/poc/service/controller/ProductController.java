package com.myRetailService.poc.service.controller;

import com.myRetailService.poc.service.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private final ProductRepository productRepository;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    @ResponseBody
    public Product getProduct(@RequestParam(name="productId") String productId) {
        LOG.info("Getting product pricing with ID: {}.", productId);
        return productRepository.findByid(productId);
    }

}

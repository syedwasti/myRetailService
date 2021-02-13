package com.myRetailService.poc.service;

import com.myRetailService.poc.dao.ProductRepository;
import com.myRetailService.poc.exception.BadRequestException;
import com.myRetailService.poc.exception.ProductNotFoundException;
import com.myRetailService.poc.model.Product;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private final ProductRepository productRepository;
    private final RedskyService redskyService;

    @Autowired
    public ProductService(ProductRepository productRepository, RedskyService redskyService) {
        this.productRepository = productRepository;
        this.redskyService = redskyService;
    }

    public Product getProduct(String id) {
        Product rProduct = redskyService.getRedskyProduct(id);
        Product dbProduct = productRepository.findByid(id);
        if(rProduct == null || dbProduct== null)
            throw new ProductNotFoundException("Product Not Found for id: " + id);
        dbProduct.setpName(rProduct.getpName());
        return dbProduct;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(String id, Product in_product) {
        if(!id.equals(in_product.getId()))
            throw new BadRequestException("Product Id's dont match:" + id + "-" + in_product.getId());

        Product product = productRepository.findByid(id);
        if(product == null)
            throw new ProductNotFoundException("Product Not Found for id: " + id);

        product.getCurrent_price().setValue(in_product.getCurrent_price().getValue());
        productRepository.save(product);
        return productRepository.findByid(id);
    }
}

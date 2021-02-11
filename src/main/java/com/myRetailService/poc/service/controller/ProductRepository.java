package com.myRetailService.poc.service.controller;

import com.myRetailService.poc.service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByid(@Param("id") String id);
}

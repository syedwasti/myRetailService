package com.myRetailService.poc.dao;

import com.myRetailService.poc.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByid(@Param("id") String id);
    List<Product> findAll();
}

package com.e_commerce.microservices.product.repository;

import com.e_commerce.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

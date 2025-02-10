package com.ecommerce.ProductService.service;


import com.ecommerce.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

}
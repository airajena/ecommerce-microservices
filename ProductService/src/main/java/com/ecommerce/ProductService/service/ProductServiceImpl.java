package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.model.ProductRequest;
import com.ecommerce.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }
}
package com.ecom.orderservice.service;

import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.external.client.ProductService;
import com.ecom.orderservice.model.OrderRequest;
import com.ecom.orderservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    @Transactional
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Creating Order with Status CREATED");

        // Reduce product quantity before placing an order
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        log.info("Order Placed successfully with Order Id: {}", order.getId());
        return order.getId();
    }
}

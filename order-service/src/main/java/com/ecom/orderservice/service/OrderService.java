package com.ecom.orderservice.service;

import com.ecom.orderservice.model.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

}

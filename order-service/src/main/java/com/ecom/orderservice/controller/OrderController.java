package com.ecom.orderservice.controller;

import com.ecom.orderservice.model.OrderRequest;
import com.ecom.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        long orderId = orderService.placeOrder(orderRequest);
        log.info("Order placed successfully with orderId: {}", orderId);
        return ResponseEntity.ok(orderId);
    }

}
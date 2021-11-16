package com.example.orderservice.controller;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.createOrder(orderEntity);
    }

    @PutMapping("/orders")
    public OrderEntity updateOrder(@RequestBody OrderEntity orderEntity) {;
        return orderService.updateOrder(orderEntity);
    }

    @GetMapping("/orders/{orderId}")
    public OrderEntity getOrderById(@PathVariable("orderId") long orderId) {
        return orderService.findOrderById(orderId);
    }

    @GetMapping("/orders")
    public Iterable<OrderEntity> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/orders/unassigned")
    public Iterable<OrderEntity> getAllUnassignedOrders() {
        return orderService.findAllUnassignedOrders();
    }

    @GetMapping("/orders/driverOrders/{driverId}")
    public Iterable<OrderEntity> getAllDriverOrders(@PathVariable long driverId) {
        return orderService.findAllDriverOrders(driverId);
    }
}

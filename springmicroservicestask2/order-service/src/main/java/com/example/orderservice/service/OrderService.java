package com.example.orderservice.service;

import com.example.orderservice.entity.OrderEntity;

public interface OrderService {

    OrderEntity createOrder(OrderEntity orderEntity);

    OrderEntity findOrderById(long orderId);

    Iterable<OrderEntity> findAllOrders();

    Iterable<OrderEntity> findAllUnassignedOrders();

    Iterable<OrderEntity> findAllDriverOrders(long driverId);

    OrderEntity updateOrder(OrderEntity orderEntity);
}

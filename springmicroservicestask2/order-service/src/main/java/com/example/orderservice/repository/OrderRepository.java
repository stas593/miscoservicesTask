package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.enums.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    Iterable<OrderEntity> findAllByOrderStatusEquals(OrderStatus orderStatus);
    Iterable<OrderEntity> findAllByDriverId(long driverId);
}

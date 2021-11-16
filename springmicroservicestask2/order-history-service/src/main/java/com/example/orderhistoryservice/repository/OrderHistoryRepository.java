package com.example.orderhistoryservice.repository;

import com.example.orderhistoryservice.entity.OrderHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderHistoryRepository extends CrudRepository<OrderHistoryEntity, Long> {
    Iterable<OrderHistoryEntity> findOrderHistoryEntitiesByOrderId(long orderId);
}

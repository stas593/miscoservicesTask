package com.example.orderhistoryservice.service;

import com.example.orderhistoryservice.entity.OrderHistoryEntity;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

public interface OrderHistorySerivce {
    Iterable<OrderHistoryEntity> getAllOrderHistoryByOrderId(long orderId);
    void msgListener(ConsumerRecord<Long, OrderHistoryEntity> record);

}

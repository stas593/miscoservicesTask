package com.example.orderhistoryservice.service;

import com.example.orderhistoryservice.entity.OrderHistoryEntity;
import com.example.orderhistoryservice.repository.OrderHistoryRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class OrderHistorySerivceImpl implements OrderHistorySerivce {

    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistorySerivceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    @Override
    public Iterable<OrderHistoryEntity> getAllOrderHistoryByOrderId(long orderId) {
        return orderHistoryRepository.findOrderHistoryEntitiesByOrderId(orderId);
    }

    @Override
    @KafkaListener(topics="orderHistory")
    public void msgListener(ConsumerRecord<Long, OrderHistoryEntity> record){
        orderHistoryRepository.save(record.value());
    }
}

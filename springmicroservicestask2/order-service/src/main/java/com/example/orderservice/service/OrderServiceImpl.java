package com.example.orderservice.service;

import com.example.orderservice.dto.OrderHistoryEntityDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<Long, OrderHistoryEntityDto> template;

    public OrderServiceImpl(OrderRepository orderRepository, KafkaTemplate<Long, OrderHistoryEntityDto> template) {
        this.orderRepository = orderRepository;
        this.template = template;
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        OrderEntity entity = orderRepository.save(orderEntity);
        OrderHistoryEntityDto orderHistoryEntityDto = new OrderHistoryEntityDto();
        orderHistoryEntityDto.setNewOrderStatus(entity.getOrderStatus());
        orderHistoryEntityDto.setOrderId(entity.getId());
        orderHistoryEntityDto.setChangeTime(entity.getOrderTime());
        template.send("orderHistory", orderHistoryEntityDto);
        return entity;
    }

    @Override
    public OrderEntity findOrderById(long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Iterable<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<OrderEntity> findAllUnassignedOrders() {
        return orderRepository.findAllByOrderStatusEquals(OrderStatus.CREATED);
    }

    @Override
    public Iterable<OrderEntity> findAllDriverOrders(long driverId) {
        return orderRepository.findAllByDriverId(driverId);
    }

    @Override
    public OrderEntity updateOrder(OrderEntity orderEntity) {
        if(orderRepository.findById(orderEntity.getId()).get().getOrderStatus() == OrderStatus.CLOSED){
            return orderEntity;
        } else {
            OrderHistoryEntityDto orderHistoryEntityDto = new OrderHistoryEntityDto();
            orderHistoryEntityDto.setOrderId(orderEntity.getId());
            orderHistoryEntityDto.setNewOrderStatus(orderEntity.getOrderStatus());
            orderHistoryEntityDto.setChangeTime(LocalDateTime.now());
            template.send("orderHistory", orderHistoryEntityDto);
            return orderRepository.save(orderEntity);
        }
    }
}

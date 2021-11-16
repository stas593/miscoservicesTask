package com.example.driverservice.service;

import com.example.driverservice.client.OrderClient;
import com.example.driverservice.dto.AssignOrderDto;
import com.example.driverservice.dto.OrderEntityDto;
import com.example.driverservice.enums.OrderStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderClient orderClient;

    public OrderServiceImpl(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @Override
    public Iterable<OrderEntityDto> getAllOrders() {
        return orderClient.getAllOrders();
    }

    @Override
    public Iterable<OrderEntityDto> getAllUnassignedOrders() {
        return orderClient.getAllUnassignedOrders();
    }

    @Override
    public Iterable<OrderEntityDto> getAllDriverOrders(long driverId) {
        return orderClient.getAllDriverOrders(driverId);
    }

    @Override
    public OrderEntityDto assignDriver(AssignOrderDto assignOrderDto) {
        OrderEntityDto orderEntity = orderClient.getOrderById(assignOrderDto.getOrderId());
        orderEntity.setDriverId(assignOrderDto.getDriverId());
        orderEntity.setOrderStatus(OrderStatus.ASSIGNED);
        return orderClient.updateOrder(orderEntity);
    }

    @Override
    public OrderEntityDto updateOrderStatus(OrderEntityDto orderEntityDto) {
        orderEntityDto.setOrderStatus(OrderStatus.update(orderEntityDto.getOrderStatus()));
        return orderClient.updateOrder(orderEntityDto);
    }

    @Override
    public OrderEntityDto getOrderById(long orderId) {
        return orderClient.getOrderById(orderId);
    }
}

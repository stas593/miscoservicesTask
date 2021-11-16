package com.example.driverservice.service;

import com.example.driverservice.dto.AssignOrderDto;
import com.example.driverservice.dto.OrderEntityDto;

import java.util.List;

public interface OrderService {
    Iterable<OrderEntityDto> getAllOrders();

    Iterable<OrderEntityDto> getAllUnassignedOrders();

    Iterable<OrderEntityDto> getAllDriverOrders(long driverId);

    OrderEntityDto assignDriver(AssignOrderDto assignOrderDto);

    OrderEntityDto updateOrderStatus(OrderEntityDto orderEntityDto);

    OrderEntityDto getOrderById(long orderId);
}

package com.example.customerservice.service;

import com.example.customerservice.dto.CreateOrderInfoDto;
import com.example.customerservice.dto.OrderEntityDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    OrderEntityDto createOrder(CreateOrderInfoDto createOrderInfoDto);
}

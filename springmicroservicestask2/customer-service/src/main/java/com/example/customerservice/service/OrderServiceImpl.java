package com.example.customerservice.service;

import com.example.customerservice.client.OrderClient;
import com.example.customerservice.dto.CreateOrderInfoDto;
import com.example.customerservice.dto.OrderEntityDto;
import com.example.customerservice.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderClient orderClient;
    private final CustomerService customerService;

    public OrderServiceImpl(OrderClient orderClient, CustomerService customerService) {
        this.orderClient = orderClient;
        this.customerService = customerService;
    }

    @Override
    public OrderEntityDto createOrder(CreateOrderInfoDto createOrderInfoDto) {
        CustomerEntity customerEntity = customerService.findCustomerByPhoneNumber(createOrderInfoDto.getPhoneNumber());
        OrderEntityDto orderEntityDto = orderClient.createOrder(OrderEntityDto.customerEntityAndCreateOrderInfoDtoToOrderEntityDto(customerEntity, createOrderInfoDto));
        return orderEntityDto;
    }
}

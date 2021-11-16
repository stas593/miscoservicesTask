package com.example.orderservice.dto;

import com.example.orderservice.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderHistoryEntityDto {
    private long id;
    private long orderId;
    private OrderStatus newOrderStatus;
    private LocalDateTime changeTime;
}
package com.example.driverservice.dto;

import com.example.driverservice.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderEntityDto {
    private long id;
    private long customerId;
    private String customerFirstName;
    private long customerPhoneNumber;
    private long driverId;
    private LocalDateTime orderTime;
    private String addressFrom;
    private String addressTo;
    private OrderStatus orderStatus;
}

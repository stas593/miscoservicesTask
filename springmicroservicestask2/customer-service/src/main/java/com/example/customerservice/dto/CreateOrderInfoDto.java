package com.example.customerservice.dto;

import lombok.Data;

@Data
public class CreateOrderInfoDto {
    private long phoneNumber;
    private String addressFrom;
    private String addressTo;
}

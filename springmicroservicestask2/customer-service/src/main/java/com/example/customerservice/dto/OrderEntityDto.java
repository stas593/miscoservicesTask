package com.example.customerservice.dto;

import com.example.customerservice.entity.CustomerEntity;
import com.example.customerservice.enums.OrderStatus;
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

    public static OrderEntityDto customerEntityAndCreateOrderInfoDtoToOrderEntityDto(CustomerEntity customerEntity, CreateOrderInfoDto createOrderInfoDto) {
        OrderEntityDto orderEntityDto = new OrderEntityDto();
        orderEntityDto.setCustomerId(customerEntity.getId());
        orderEntityDto.setCustomerFirstName(customerEntity.getFirstName());
        orderEntityDto.setCustomerPhoneNumber(customerEntity.getPhoneNumber());
        orderEntityDto.setAddressFrom(createOrderInfoDto.getAddressFrom());
        orderEntityDto.setAddressTo(createOrderInfoDto.getAddressTo());
        return orderEntityDto;
    }
}

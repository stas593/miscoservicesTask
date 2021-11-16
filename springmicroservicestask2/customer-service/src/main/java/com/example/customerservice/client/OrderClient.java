package com.example.customerservice.client;

import com.example.customerservice.dto.OrderEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("orderservice")
public interface OrderClient {
    @PostMapping("/api/orders")
    OrderEntityDto createOrder(OrderEntityDto orderEntityDto);
}

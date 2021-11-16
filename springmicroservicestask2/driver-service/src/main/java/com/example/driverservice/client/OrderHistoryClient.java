package com.example.driverservice.client;

import com.example.driverservice.dto.OrderHistoryEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("orderhistoryservice")
public interface OrderHistoryClient {
    @GetMapping("/api/orderhistory/{orderId}")
    Iterable<OrderHistoryEntityDto> getALLOrderHistoryById(@PathVariable("orderId") long orderId);
}

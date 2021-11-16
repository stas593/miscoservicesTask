package com.example.driverservice.client;

import com.example.driverservice.dto.OrderEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "orderservice")
public interface OrderClient {
    @GetMapping("/api/orders")
    Iterable<OrderEntityDto> getAllOrders();

    @GetMapping("/api/orders/unassigned")
    Iterable<OrderEntityDto> getAllUnassignedOrders();

    @GetMapping("/api/orders/driverOrders/{driverId}")
    Iterable<OrderEntityDto> getAllDriverOrders(@PathVariable long driverId);

    @PutMapping("/api/orders")
    OrderEntityDto updateOrder(@RequestBody OrderEntityDto orderEntityDto);

    @GetMapping("/api/orders/{orderId}")
    OrderEntityDto getOrderById(@PathVariable("orderId") long orderId);
}

package com.example.orderhistoryservice.controller;

import com.example.orderhistoryservice.entity.OrderHistoryEntity;
import com.example.orderhistoryservice.service.OrderHistorySerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderhistory")
public class OrderHistoryController {

    private final OrderHistorySerivce orderHistorySerivce;

    public OrderHistoryController(OrderHistorySerivce orderHistorySerivce) {
        this.orderHistorySerivce = orderHistorySerivce;
    }

    @GetMapping("/{orderId}")
    Iterable<OrderHistoryEntity> getALLOrderHistoryById(@PathVariable("orderId") long orderId){
        return orderHistorySerivce.getAllOrderHistoryByOrderId(orderId);
    }


}

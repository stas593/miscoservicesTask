package com.example.driverservice.controller;

import com.example.driverservice.client.OrderHistoryClient;
import com.example.driverservice.dto.AssignOrderDto;
import com.example.driverservice.dto.OrderEntityDto;
import com.example.driverservice.dto.OrderHistoryEntityDto;
import com.example.driverservice.entity.DriverEntity;
import com.example.driverservice.enums.OrderStatus;
import com.example.driverservice.exception.DriverDoesnAssignOrderException;
import com.example.driverservice.service.DriverService;
import com.example.driverservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DriverController {

    private final DriverService driverService;
    private final OrderService orderService;
    private final OrderHistoryClient orderHistoryClient;

    public DriverController(DriverService driverService, OrderService orderService, OrderHistoryClient orderHistoryClient) {
        this.driverService = driverService;
        this.orderService = orderService;
        this.orderHistoryClient = orderHistoryClient;
    }

    @PostMapping("/drivers")
    public DriverEntity createDriver(@RequestBody DriverEntity driverEntity) {
        return driverService.createDriver(driverEntity);
    }

    @GetMapping("/drivers")
    public Iterable<DriverEntity> getAllDrivers() {
        return driverService.findAllDrivers();
    }

    @GetMapping("/drivers/unassignedOrders")
    public Iterable<OrderEntityDto> getAllUnassignedOrders() {
        return orderService.getAllUnassignedOrders();
    }

    @GetMapping("/drivers/orderHistory/{orderId}")
    public Iterable<OrderHistoryEntityDto> getOrderHistory(@PathVariable("orderId") long orderId) {
        return orderHistoryClient.getALLOrderHistoryById(orderId);
    }

    @PutMapping("/drivers/assignDriver")
    public ResponseEntity<OrderEntityDto> assignDriver(@RequestBody AssignOrderDto assignOrderDto) {
        driverService.findDriverById(assignOrderDto.getDriverId());
        OrderEntityDto order = orderService.getOrderById(assignOrderDto.getOrderId());
        if(order.getOrderStatus() == OrderStatus.ASSIGNED){
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(orderService.assignDriver(assignOrderDto), HttpStatus.OK);
    }

    @GetMapping("/drivers/driverOrders/{driverId}")
    ResponseEntity<Iterable<OrderEntityDto>> getDriverOrders(@PathVariable("driverId") long driverId) {
        DriverEntity driverEntity = driverService.findDriverById(driverId);
        Iterable<OrderEntityDto> orderEntity = orderService.getAllDriverOrders(driverEntity.getId());
        return new ResponseEntity<>(orderEntity, HttpStatus.OK);
    }

    @PutMapping("/drivers/updateOrder")
    ResponseEntity<OrderEntityDto> updateOrderStatus(@RequestBody AssignOrderDto assignOrderDto) throws DriverDoesnAssignOrderException {
        DriverEntity driverEntity = driverService.findDriverById(assignOrderDto.getDriverId());
        OrderEntityDto orderEntityDto = orderService.getOrderById(assignOrderDto.getOrderId());
        if (driverEntity.getId() != orderEntityDto.getDriverId()) {
            throw new DriverDoesnAssignOrderException("driver does not have this order");
        }
        return new ResponseEntity<>(orderService.updateOrderStatus(orderEntityDto), HttpStatus.OK);
    }
}

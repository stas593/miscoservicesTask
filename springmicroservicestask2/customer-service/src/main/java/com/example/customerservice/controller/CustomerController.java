package com.example.customerservice.controller;

import com.example.customerservice.dto.CreateOrderInfoDto;
import com.example.customerservice.dto.OrderEntityDto;
import com.example.customerservice.entity.CustomerEntity;
import com.example.customerservice.service.CustomerService;
import com.example.customerservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping("/customers")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customerEntity) {
        return customerService.addCustomer(customerEntity);
    }

    @GetMapping("/customers")
    public Iterable<CustomerEntity> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") long id) {
        CustomerEntity customerEntity = customerService.findCustomerById(id);
        return new ResponseEntity<>(customerEntity, HttpStatus.OK);
    }

    @GetMapping("/customers/phoneNumber/{phoneNumber}")
    public ResponseEntity<CustomerEntity> getCustomerByPhoneNumber(@PathVariable("phoneNumber") long phoneNumber) {
        CustomerEntity customerEntity = customerService.findCustomerByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(customerEntity, HttpStatus.OK);
    }

    @PostMapping("/customers/createOrder")
    public ResponseEntity<OrderEntityDto> createOrder(@RequestBody CreateOrderInfoDto createOrderInfoDto) {
        OrderEntityDto orderEntityDto = orderService.createOrder(createOrderInfoDto);
        return new ResponseEntity<>(orderEntityDto, HttpStatus.OK);
    }
}

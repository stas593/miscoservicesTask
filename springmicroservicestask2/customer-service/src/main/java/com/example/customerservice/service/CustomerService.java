package com.example.customerservice.service;

import com.example.customerservice.entity.CustomerEntity;

public interface CustomerService {
    CustomerEntity addCustomer(CustomerEntity customerEntity);

    Iterable<CustomerEntity> findAllCustomers();

    CustomerEntity findCustomerById(long id);

    CustomerEntity findCustomerByPhoneNumber(long phoneNumber);
}

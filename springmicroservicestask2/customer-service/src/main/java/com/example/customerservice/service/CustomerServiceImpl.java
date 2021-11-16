package com.example.customerservice.service;

import com.example.customerservice.entity.CustomerEntity;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerEntity addCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    @Override
    public Iterable<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findCustomerById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomerEntity findCustomerByPhoneNumber(long phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber).get();
    }
}

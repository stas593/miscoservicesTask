package com.example.customerservice.repository;

import com.example.customerservice.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByPhoneNumber(long phoneNumber);
}

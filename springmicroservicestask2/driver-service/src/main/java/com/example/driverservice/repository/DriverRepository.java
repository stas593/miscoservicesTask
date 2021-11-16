package com.example.driverservice.repository;

import com.example.driverservice.entity.DriverEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriverRepository extends CrudRepository<DriverEntity, Long> {
    Optional<DriverEntity> findByPhoneNumber(Long phoneNumber);
}

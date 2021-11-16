package com.example.driverservice.service;

import com.example.driverservice.entity.DriverEntity;

public interface DriverService {
    Iterable<DriverEntity> findAllDrivers();
    DriverEntity findDriverById(long id);
    DriverEntity findDriverByPhoneNumber(long phoneNumber);
    DriverEntity createDriver(DriverEntity driverEntity);
}

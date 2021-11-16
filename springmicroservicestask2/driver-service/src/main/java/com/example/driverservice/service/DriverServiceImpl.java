package com.example.driverservice.service;

import com.example.driverservice.entity.DriverEntity;
import com.example.driverservice.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Iterable<DriverEntity> findAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public DriverEntity findDriverById(long id) {
        return driverRepository.findById(id).get();
    }

    @Override
    public DriverEntity findDriverByPhoneNumber(long phoneNumber) {
        return driverRepository.findByPhoneNumber(phoneNumber).get();
    }

    @Override
    public DriverEntity createDriver(DriverEntity driverEntity) {
        return driverRepository.save(driverEntity);
    }
}

package com.aayush.smart_parking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aayush.smart_parking_system.entity.Vehicle;
import com.aayush.smart_parking_system.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
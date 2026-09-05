package com.aayush.smart_parking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aayush.smart_parking_system.entity.Vehicle;
import com.aayush.smart_parking_system.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }
}

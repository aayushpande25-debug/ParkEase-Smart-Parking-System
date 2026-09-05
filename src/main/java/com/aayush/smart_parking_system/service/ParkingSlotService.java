package com.aayush.smart_parking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aayush.smart_parking_system.entity.ParkingSlot;
import com.aayush.smart_parking_system.repository.ParkingSlotRepository;

@Service
public class ParkingSlotService {

    private final ParkingSlotRepository repository;

    public ParkingSlotService(ParkingSlotRepository repository) {
        this.repository = repository;
    }

    public ParkingSlot save(ParkingSlot slot) {
        return repository.save(slot);
    }

    public List<ParkingSlot> getAll() {
        return repository.findAll();
    }

    public ParkingSlot updateStatus(String slotNumber, String status) {

        List<ParkingSlot> slots = repository.findAll();

        for (ParkingSlot slot : slots) {

            if (slot.getSlotNumber().equals(slotNumber)) {

                slot.setStatus(status);

                return repository.save(slot);
            }
        }

        throw new RuntimeException("Parking slot not found");
    }
}
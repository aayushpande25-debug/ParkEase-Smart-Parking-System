package com.aayush.smart_parking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aayush.smart_parking_system.entity.ParkingSlot;
import com.aayush.smart_parking_system.service.ParkingSlotService;

@RestController
@RequestMapping("/slots")
public class ParkingSlotController {

    private final ParkingSlotService service;

    public ParkingSlotController(ParkingSlotService service) {
        this.service = service;
    }

    @PostMapping
    public ParkingSlot addSlot(@RequestBody ParkingSlot slot) {
        return service.save(slot);
    }

    @GetMapping
    public List<ParkingSlot> getSlots() {
        return service.getAll();
    }

     @PutMapping("/{slotNumber}/status")
    public ParkingSlot updateStatus(
            @PathVariable String slotNumber,
            @RequestParam String status) {

        return service.updateStatus(slotNumber, status);
    }
}

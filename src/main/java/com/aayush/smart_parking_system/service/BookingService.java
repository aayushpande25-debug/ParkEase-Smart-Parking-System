package com.aayush.smart_parking_system.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aayush.smart_parking_system.entity.Booking;
import com.aayush.smart_parking_system.entity.ParkingSlot;
import com.aayush.smart_parking_system.repository.BookingRepository;
import com.aayush.smart_parking_system.repository.ParkingSlotRepository;

@Service
public class BookingService {

    private static final double HOURLY_RATE = 20.0;

    private final BookingRepository repository;
    private final ParkingSlotRepository parkingSlotRepository;

    public BookingService(BookingRepository repository,
                           ParkingSlotRepository parkingSlotRepository) {
        this.repository = repository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public Booking bookSlot(Booking booking) {
        if (booking.getVehicleNumber() == null || booking.getVehicleNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number is required");
        }

        if (booking.getSlotNumber() == null || booking.getSlotNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Slot number is required");
        }

        ParkingSlot slot = findSlot(booking.getSlotNumber());

        if (!"AVAILABLE".equalsIgnoreCase(slot.getStatus())) {
            throw new IllegalStateException("Parking slot is not available");
        }

        booking.setVehicleNumber(booking.getVehicleNumber().trim().toUpperCase());
        booking.setEntryTime(LocalDateTime.now());
        booking.setExitTime(null);
        booking.setAmount(null);

        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking checkout(Long id) {
        Booking booking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getExitTime() != null) {
            throw new IllegalStateException("Booking is already checked out");
        }

        LocalDateTime exitTime = LocalDateTime.now();
        booking.setExitTime(exitTime);

        long minutes = Math.max(1, Duration.between(booking.getEntryTime(), exitTime).toMinutes());
        long hours = (long) Math.ceil(minutes / 60.0);
        booking.setAmount(hours * HOURLY_RATE);

        ParkingSlot slot = findSlot(booking.getSlotNumber());
        slot.setStatus("AVAILABLE");
        parkingSlotRepository.save(slot);

        return repository.save(booking);
    }

    private ParkingSlot findSlot(String slotNumber) {
        return parkingSlotRepository.findAll().stream()
                .filter(slot -> slot.getSlotNumber().equalsIgnoreCase(slotNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Parking slot not found"));
    }
}

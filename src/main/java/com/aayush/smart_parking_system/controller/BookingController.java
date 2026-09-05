package com.aayush.smart_parking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aayush.smart_parking_system.entity.Booking;
import com.aayush.smart_parking_system.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking book(@RequestBody Booking booking) {
        return service.bookSlot(booking);
    }

    @GetMapping
    public List<Booking> getBookings() {
        return service.getAllBookings();
    }

    @PutMapping("/{id}/checkout")
    public Booking checkout(@PathVariable Long id) {
        return service.checkout(id);
    }
}

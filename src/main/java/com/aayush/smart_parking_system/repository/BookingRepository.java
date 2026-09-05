package com.aayush.smart_parking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aayush.smart_parking_system.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

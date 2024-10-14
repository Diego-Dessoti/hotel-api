package com.example.hotel_reservation_system.dto.booking;

import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.model.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterBookingDTO(Long id,
                                 Long clientId,
                                 Long roomId,
                                 LocalDateTime checkIn,
                                 LocalDateTime checkOut,
                                 String status) {
}

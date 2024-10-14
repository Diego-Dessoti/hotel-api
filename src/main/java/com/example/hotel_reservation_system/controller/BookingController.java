package com.example.hotel_reservation_system.controller;

import com.example.hotel_reservation_system.dto.booking.RegisterBookingDTO;
import com.example.hotel_reservation_system.model.Booking;
import com.example.hotel_reservation_system.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @PostMapping
    public Booking booking(@RequestBody RegisterBookingDTO dto){
        return service.create(dto);
    }

    @GetMapping("/conflicting-dates")
    public ResponseEntity<List<LocalDateTime[]>> getConflictingDates(
            @RequestParam Long roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkOut) {

        // Chamando o serviço para obter as datas conflitantes
        List<LocalDateTime[]> conflictingDates = service.getConflictingDates(roomId, checkIn, checkOut);

        if (conflictingDates.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver conflitos
        }

        return ResponseEntity.ok(conflictingDates); // Retorna 200 com as datas ocupadas
    }
}

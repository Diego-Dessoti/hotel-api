package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.dto.booking.RegisterBookingDTO;
import com.example.hotel_reservation_system.model.Booking;
import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoomService roomService;


    public Booking create(RegisterBookingDTO dto) {
        Client client = clientService.findById(dto.clientId());
        Room room = roomService.findById(dto.roomId());


        return repository.save(new Booking(null,
                client, room, dto.checkIn(),
                dto.checkOut(), dto.status()));
    }

    public List<LocalDateTime[]> getConflictingDates(Long roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        List<Object[]> result = repository.findConflictingDates(roomId, checkIn, checkOut);

        List<LocalDateTime[]> conflictingDates = new ArrayList<>();
        for (Object[] row : result) {
            LocalDateTime start = ((Timestamp) row[0]).toLocalDateTime();
            LocalDateTime end = ((Timestamp) row[1]).toLocalDateTime();
            conflictingDates.add(new LocalDateTime[]{start, end});
        }

        return conflictingDates;
    }
}

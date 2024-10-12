package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;


}

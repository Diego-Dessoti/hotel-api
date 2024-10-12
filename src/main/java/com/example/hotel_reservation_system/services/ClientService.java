package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.repositories.BookingRepository;
import com.example.hotel_reservation_system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;


}

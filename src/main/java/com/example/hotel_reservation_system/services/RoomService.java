package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;
}

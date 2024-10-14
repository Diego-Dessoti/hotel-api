package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.dto.room.RegisterRoomRequestDTO;
import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public List<Room> getAllRooms(){
        return repository.findAll();
    }

    public Room create(RegisterRoomRequestDTO dto){
        return repository.save(new Room(dto));
    }

    public Room findById(Long id){
        return repository.findById(id).get();
    }
}

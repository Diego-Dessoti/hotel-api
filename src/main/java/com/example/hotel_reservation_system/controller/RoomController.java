package com.example.hotel_reservation_system.controller;

import com.example.hotel_reservation_system.dto.room.RegisterRoomRequestDTO;
import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<List<Room>> findALl(){
        List<Room> rooms = service.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }

    @PostMapping("/register")
    public ResponseEntity<Room> create(@RequestBody RegisterRoomRequestDTO dto){
        Room room = service.create(dto);
        return ResponseEntity.ok().body(room);
    }

}

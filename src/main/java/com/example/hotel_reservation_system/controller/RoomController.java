package com.example.hotel_reservation_system.controller;

import com.example.hotel_reservation_system.dto.room.RegisterRoomRequestDTO;
import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.model.RoomImages;
import com.example.hotel_reservation_system.repositories.RoomImageRepository;
import com.example.hotel_reservation_system.services.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService service;

    @Autowired
    private RoomImageRepository roomImagesRepository;

    @GetMapping("")
    public ResponseEntity<List<Room>> findALl(){
        System.out.println("teste");
        List<Room> rooms = service.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }

    @PostMapping("/register")
    public ResponseEntity<Room> create(
            @RequestParam("roomData") String roomDataJson,
            @RequestParam("images") List<MultipartFile> images) {

        try {
            Room savedRoom = service.createRoomWithImages(roomDataJson, images);
            return ResponseEntity.ok().body(savedRoom);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

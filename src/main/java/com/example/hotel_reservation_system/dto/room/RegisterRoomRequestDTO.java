package com.example.hotel_reservation_system.dto.room;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record RegisterRoomRequestDTO(Long id,
                                     String type,
                                     Double price,
                                     Byte available,
                                     String description,
                                     List<MultipartFile> images) {
}
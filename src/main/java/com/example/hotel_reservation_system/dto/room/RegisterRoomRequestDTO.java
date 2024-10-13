package com.example.hotel_reservation_system.dto.room;

public record RegisterRoomRequestDTO(Long id,
                                     String type,
                                     Double price,
                                     Byte avaliable,
                                     String description) {
}

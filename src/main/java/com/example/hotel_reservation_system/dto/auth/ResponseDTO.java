package com.example.hotel_reservation_system.dto.auth;

public record ResponseDTO(    Long userId,
                              Long clientId,
                              String email,
                              String name,
                              String phone,
                              String address,
                              String token) {
}

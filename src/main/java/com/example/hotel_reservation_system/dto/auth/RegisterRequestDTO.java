package com.example.hotel_reservation_system.dto.auth;

public record RegisterRequestDTO(String name,
                                 String email,
                                 String password,
                                 String phone,
                                 String address) {
}

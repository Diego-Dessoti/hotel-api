package com.example.hotel_reservation_system.dto;

public record RegisterRequestDTO(String name,
                                 String email,
                                 String password,
                                 String phone,
                                 String address) {
}

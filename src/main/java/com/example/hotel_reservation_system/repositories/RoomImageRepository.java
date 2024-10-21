package com.example.hotel_reservation_system.repositories;

import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.model.RoomImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomImageRepository extends JpaRepository<RoomImages, Long> {
}

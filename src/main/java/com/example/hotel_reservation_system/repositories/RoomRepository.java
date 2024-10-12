package com.example.hotel_reservation_system.repositories;

import com.example.hotel_reservation_system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

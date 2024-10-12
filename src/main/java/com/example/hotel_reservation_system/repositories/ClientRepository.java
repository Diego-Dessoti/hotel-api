package com.example.hotel_reservation_system.repositories;

import com.example.hotel_reservation_system.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

package com.example.hotel_reservation_system.repositories;

import com.example.hotel_reservation_system.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

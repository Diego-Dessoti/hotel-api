package com.example.hotel_reservation_system.repositories;

import com.example.hotel_reservation_system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b.check_in, b.check_out FROM Booking b " +
            "WHERE b.room_id = ?1 " +
            "AND ((b.check_in <= ?3 AND b.check_out >= ?2))", nativeQuery = true)
    List<Object[]> findConflictingDates(Long roomId, LocalDateTime checkIn, LocalDateTime checkOut);


}

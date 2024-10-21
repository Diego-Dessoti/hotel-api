package com.example.hotel_reservation_system.model;

import com.example.hotel_reservation_system.dto.room.RegisterRoomRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double price;
    private Byte available;
    private String description;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomImages> images;

    public Room(RegisterRoomRequestDTO dto){
        this.id = null;
        this.type = dto.type();
        this.price = dto.price();
        this.available = dto.available();
        this.description = dto.description();
    }
}

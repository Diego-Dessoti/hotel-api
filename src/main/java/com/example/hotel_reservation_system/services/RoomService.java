package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.dto.room.RegisterRoomRequestDTO;
import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.model.Room;
import com.example.hotel_reservation_system.model.RoomImages;
import com.example.hotel_reservation_system.repositories.RoomImageRepository;
import com.example.hotel_reservation_system.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    @Autowired
    private RoomImageRepository imageRepository;

    public List<Room> getAllRooms(){
        return repository.findAll();
    }

    public Room createRoomWithImages(String roomDataJson, List<MultipartFile> images) throws IOException {
        // Mapeamento manual do JSON para o objeto Room
        String[] properties = roomDataJson.replace("{", "").replace("}", "").replace("\"", "").split(",");
        Room room = new Room();

        for (String property : properties) {
            String[] keyValue = property.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "id":
                    room.setId(value.equals("null") ? null : Long.valueOf(value));
                    break;
                case "type":
                    room.setType(value);
                    break;
                case "price":
                    room.setPrice(Double.valueOf(value));
                    break;
                case "avaliable":
                    room.setAvailable(Byte.valueOf(value));
                    break;
                case "description":
                    room.setDescription(value);
                    break;
            }
        }

        Room savedRoom = repository.save(room);

        for (MultipartFile image : images) {
            byte[] imageBytes = image.getBytes();
            RoomImages roomImage = new RoomImages();
            roomImage.setRoom(savedRoom);
            roomImage.setImageData(imageBytes);

            imageRepository.save(roomImage);
        }

        return savedRoom;
    }


    public Room findById(Long id){
        return repository.findById(id).get();
    }
}

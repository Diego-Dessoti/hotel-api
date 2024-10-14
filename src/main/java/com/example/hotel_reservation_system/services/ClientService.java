package com.example.hotel_reservation_system.services;

import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.repositories.BookingRepository;
import com.example.hotel_reservation_system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;


    public Client create(Client client){
        try{
            return repository.save(client);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public Client findById(Long id){
        return repository.findById(id).get();
    }
}

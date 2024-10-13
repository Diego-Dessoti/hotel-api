package com.example.hotel_reservation_system.controller;


import com.example.hotel_reservation_system.config.TokenService;
import com.example.hotel_reservation_system.dto.auth.LoginRequestDTO;
import com.example.hotel_reservation_system.dto.auth.RegisterRequestDTO;
import com.example.hotel_reservation_system.dto.auth.ResponseDTO;
import com.example.hotel_reservation_system.model.Client;
import com.example.hotel_reservation_system.model.User;
import com.example.hotel_reservation_system.repositories.UserRepository;
import com.example.hotel_reservation_system.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ClientService clientService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(),user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok().body((new ResponseDTO(user.getId(),
                    user.getClient().getId(), user.getEmail(),
                    user.getName(), user.getClient().getPhone(),
                    user.getClient().getAddress(), token )));
        };
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()){
            User newUser = new User();

            Client client = new Client(null, body.email(), body.name(), body.phone(),body.address());
            client = clientService.create(client);
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setName(body.name());
            newUser.setEmail(body.email());
            newUser.setClient(client);
            this.repository.save(newUser);


            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok().body(new ResponseDTO(newUser.getId(),
                                                    newUser.getClient().getId(), newUser.getEmail(),
                                                    newUser.getName(), newUser.getClient().getPhone(),
                                                    newUser.getClient().getAddress(), token ));

        }


        return ResponseEntity.badRequest().build();
    }
}

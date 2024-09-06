package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUser createUser){
        userHandler.saveWareHouseAssistantUser(createUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.handler.IUserHandler;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private IUserHandler userHandler;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        // Initialize mocks
    }

    @Test
    void createWareHouseAssUser_ValidUser_ReturnsCreatedResponse() {
        // Arrange
        CreateUser createUser = UserFactory.getCreateUser();
        UserResponse userResponse =UserFactory.getUserResponse();

        when(userHandler.saveWareHouseAssistantUser(createUser)).thenReturn(userResponse);

        // Act
        ResponseEntity<UserResponse> response = userController.createWareHouseAssUser(createUser);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
        verify(userHandler, times(1)).saveWareHouseAssistantUser(createUser);
    }

    @Test
    void createClientUser_ValidUser_ReturnsCreatedResponse() {
        // Arrange
        CreateUser createUser = UserFactory.getCreateUser();
        UserResponse userResponse =UserFactory.getUserResponse();

        when(userHandler.saveClientUser(createUser)).thenReturn(userResponse);

        // Act
        ResponseEntity<UserResponse> response = userController.createClientUser(createUser);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
        verify(userHandler, times(1)).saveClientUser(createUser);
    }

}
package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {
    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;


    @Test
    void login_ValidRequest_ReturnsAuthenticationResponse() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest();
        AuthenticationResponse expectedResponse = new AuthenticationResponse();

        when(authenticationService.login(request)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AuthenticationResponse> response = authenticationController.login(request);

        // Assert
        assertEquals(ResponseEntity.ok(expectedResponse), response);
        verify(authenticationService, times(1)).login(request);
    }
}
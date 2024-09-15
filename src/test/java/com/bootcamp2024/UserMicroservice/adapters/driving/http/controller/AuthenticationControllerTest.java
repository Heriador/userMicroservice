package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.handler.AuthHandler;
import com.bootcamp2024.UserMicroservice.factory.AuthFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {
    @Mock
    private AuthHandler authHandler;

    @InjectMocks
    private AuthenticationController authenticationController;


    @Test
    void login_ValidRequest_ReturnsAuthenticationResponse() {
        // Arrange
        AuthenticationRequest request = AuthFactory.getAuthenticationRequest();
        AuthenticationResponse response = AuthFactory.getAuthenticationResponse();

        when(authHandler.login(request)).thenReturn(response);

        // Act
        ResponseEntity<AuthenticationResponse> actualResponse = authenticationController.login(request);


        assertEquals(response.getJwt(), Objects.requireNonNull(actualResponse.getBody()).getJwt());

        verify(authHandler, times(1)).login(request);
    }
}
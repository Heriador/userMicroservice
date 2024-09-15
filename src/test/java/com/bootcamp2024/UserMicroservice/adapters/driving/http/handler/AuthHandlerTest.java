package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.bootcamp2024.UserMicroservice.domain.api.IAuthServicePort;
import com.bootcamp2024.UserMicroservice.factory.AuthFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AuthHandlerTest {

    @Mock
    private IAuthServicePort authServicePort;

    @InjectMocks
    private  AuthHandler authHandler;


    @Test
    void login_shouldPass_returnResponseToken() {

        AuthenticationRequest request = AuthFactory.getAuthenticationRequest();

        when(authServicePort.login(request.getEmail(), request.getPassword())).thenReturn(AuthFactory.getAuthenticationResponse().getJwt());

        AuthenticationResponse response = authHandler.login(request);

        assertEquals(AuthFactory.getAuthenticationResponse().getJwt(), response.getJwt());

    }

}
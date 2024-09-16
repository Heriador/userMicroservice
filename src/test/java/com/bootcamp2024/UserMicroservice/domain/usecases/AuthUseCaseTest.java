package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.exception.AuthenticationException;
import com.bootcamp2024.UserMicroservice.domain.spi.IAuthPersistencePort;
import com.bootcamp2024.UserMicroservice.factory.AuthFactory;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AuthUseCaseTest {

    @Mock
    private IAuthPersistencePort authPersistencePort;

    @InjectMocks
    private AuthUseCase authUseCase;


    @Test
    void  login_ValidCredentials_ReturnsToken() {

        String email = AuthFactory.getAuthenticationRequest().getEmail();
        String password = AuthFactory.getAuthenticationRequest().getPassword();

        when(authPersistencePort.validateCredentials(email, password)).thenReturn(true);

        when(authPersistencePort.authenticate(email, password)).thenReturn(UserFactory.getUser());

        when(authPersistencePort.generateToken(UserFactory.getUser())).thenReturn(AuthFactory.getAuthenticationResponse().getJwt());

        String token = authUseCase.login(email, password);

        assertEquals(AuthFactory.getAuthenticationResponse().getJwt(), token);


    }

    @Test
    void login_InvalidCredentials_ThrowsException() {

        String email = AuthFactory.getAuthenticationRequest().getEmail();
        String password = AuthFactory.getAuthenticationRequest().getPassword();

        when(authPersistencePort.validateCredentials(email, password)).thenReturn(false);

        assertThrows(AuthenticationException.class, () -> authUseCase.login(email, password));


    }
}
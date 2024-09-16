package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.JwtService;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;
import com.bootcamp2024.UserMicroservice.factory.AuthFactory;
import com.bootcamp2024.UserMicroservice.factory.RoleFactory;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthAdapterTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private AuthAdapter authAdapter;

    @Test
    void authenticate_shouldReturnUser() {

        Authentication authUser = mock(Authentication.class);
        CustomUserDetails customUserDetails = new CustomUserDetails(UserFactory.getUserEntity());

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authUser);
        when(authUser.getPrincipal()).thenReturn(customUserDetails);

        User user = authAdapter.authenticate(AuthFactory.getAuthenticationRequest().getEmail(), AuthFactory.getAuthenticationRequest().getPassword());

        assertEquals(UserFactory.getUser().getId(), user.getId());
    }

    @Test
    void validateCredentials_shouldReturnTrue() {

        Authentication authUser = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authUser);
        when(authUser.isAuthenticated()).thenReturn(true);

        boolean isValid = authAdapter.validateCredentials(AuthFactory.getAuthenticationRequest().getEmail(), AuthFactory.getAuthenticationRequest().getPassword());

        assertTrue(isValid);
    }

    @Test
    void validateCredentials_shouldReturnFalse() {

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenThrow(BadCredentialsException.class);

        boolean isValid = authAdapter.validateCredentials(AuthFactory.getAuthenticationRequest().getEmail(), AuthFactory.getAuthenticationRequest().getPassword());

        assertFalse(isValid);
    }

    @Test
    void generateToken_shouldReturnToken() {

        User user = UserFactory.getUser();

        when(jwtService.generateToken(any(User.class), anyMap())).thenReturn(AuthFactory.getAuthenticationResponse().getJwt());
        when(rolePersistencePort.getRoleName(user.getRoleId())).thenReturn(RoleFactory.getRole());

        String token = authAdapter.generateToken(user);

        assertEquals(AuthFactory.getAuthenticationResponse().getJwt(), token);
    }

}
package com.bootcamp2024.UserMicroservice.factory;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthFactory {

    private static final AuthenticationRequest authenticationRequest;
    private static final AuthenticationResponse authenticationResponse;

    static {
        authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("john.doe@gmail.com");
        authenticationRequest.setPassword("password");

        authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setJwt("valid token");
    }

    public static AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public static AuthenticationResponse getAuthenticationResponse() {
        return authenticationResponse;
    }

}

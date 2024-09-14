package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.bootcamp2024.UserMicroservice.domain.api.IAuthServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandler implements IAuthHandler {

    private final IAuthServicePort authServicePort;


    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {

        String jwt = authServicePort.login(request.getEmail(), request.getPassword());

        return new AuthenticationResponse(jwt);
    }
}

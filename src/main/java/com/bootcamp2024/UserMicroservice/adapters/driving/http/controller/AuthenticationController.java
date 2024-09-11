package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.RestControllerConstants;
import com.bootcamp2024.UserMicroservice.configuration.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestControllerConstants.AUTHENTICATION_RUTE)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(RestControllerConstants.AUTHENTICATE_RUTE)
    @PreAuthorize(RestControllerConstants.PERMIT_ALL)
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest request) {

        AuthenticationResponse jwtDto = authenticationService.login(request);


        return ResponseEntity.ok(jwtDto);
    }
}

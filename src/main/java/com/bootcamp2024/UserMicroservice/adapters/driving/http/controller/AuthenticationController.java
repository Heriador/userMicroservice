package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.RestControllerConstants;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.openapi.controller.DocumentationConstants;
import com.bootcamp2024.UserMicroservice.configuration.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestControllerConstants.AUTHENTICATION_RUTE)
@RequiredArgsConstructor
@Tag(name = DocumentationConstants.AUTHENTICATION_CONTROLLER_TAG, description = DocumentationConstants.AUTHENTICATION_CONTROLLER_DESCRIPTION)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = DocumentationConstants.AUTHENTICATION_CONTROLLER_OPERATION_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = DocumentationConstants.CODE_STATUS_201, description = DocumentationConstants.DESCRIPTION_STATUS_201, content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = DocumentationConstants.CODE_STATUS_403, description = DocumentationConstants.DESCRIPTION_STATUS_403, content = @Content),
    })
    @PostMapping(RestControllerConstants.AUTHENTICATE_RUTE)
    @PreAuthorize(RestControllerConstants.PERMIT_ALL)
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest request) {

        AuthenticationResponse jwtDto = authenticationService.login(request);


        return ResponseEntity.ok(jwtDto);
    }
}

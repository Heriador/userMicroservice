package com.bootcamp2024.UserMicroservice.adapters.driving.http.controller;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.handler.IUserHandler;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.RestControllerConstants;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.openapi.controller.DocumentationConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestControllerConstants.USERS_RUTE)
@RequiredArgsConstructor
@Tag(name = DocumentationConstants.USER_CONTROLLER_TAG, description = DocumentationConstants.USER_CONTROLLER_DESCRIPTION)
public class UserController {
    private final IUserHandler userHandler;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),

    })
    @PreAuthorize(RestControllerConstants.HAS_ROLE_ADMIN)
    @PostMapping(RestControllerConstants.WAREHOUSE_ASSISTANT_RUTE)
    @Operation(summary = DocumentationConstants.CREATE_WAREHOUSE_ASSISTANT_USER_OPERATION_DESCIPTION)
    public ResponseEntity<UserResponse> createWareHouseAssUser(@RequestBody @Valid CreateUser createUser){
        UserResponse user = userHandler.saveWareHouseAssistantUser(createUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}

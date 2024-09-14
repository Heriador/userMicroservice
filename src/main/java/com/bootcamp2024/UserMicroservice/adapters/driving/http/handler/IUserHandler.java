package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;

public interface IUserHandler {
    UserResponse saveWareHouseAssistantUser(CreateUser user);

}

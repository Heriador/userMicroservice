package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;

public interface IUserHandler {
    void saveWareHouseAssistantUser(CreateUser user);
}

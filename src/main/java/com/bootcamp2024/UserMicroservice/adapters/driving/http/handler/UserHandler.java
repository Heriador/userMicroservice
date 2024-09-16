package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;


    @Override
    public UserResponse saveWareHouseAssistantUser(CreateUser createUser) {
        User user = userRequestMapper.toUser(createUser);

        userServicePort.saveWareHouseAssistantUser(user);

        return userResponseMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse saveClientUser(CreateUser createUser) {
        User user = userRequestMapper.toUser(createUser);

        userServicePort.saveClientUser(user);


        return userResponseMapper.userToUserResponse(user);
    }
}

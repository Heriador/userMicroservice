package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.bootcamp2024.UserMicroservice.domain.api.IRoleServicePort;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.util.RoleConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IRoleServicePort roleServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;


    @Override
    public UserResponse saveWareHouseAssistantUser(CreateUser createUser) {
        User user = userRequestMapper.toUser(createUser);
        user.setRole(roleServicePort.getRole(RoleConstant.WAREHOUSE_ASSISTANT.toString()));

        userServicePort.saveWareHouseAssistantUser(user);

        return userResponseMapper.userToUserResponse(user);
    }
}

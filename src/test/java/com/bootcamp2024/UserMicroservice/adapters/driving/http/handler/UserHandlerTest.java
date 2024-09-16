package com.bootcamp2024.UserMicroservice.adapters.driving.http.handler;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest {
    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IUserRequestMapper userRequestMapper;

    @Mock
    private IUserResponseMapper userResponseMapper;

    @InjectMocks
    private UserHandler userHandler;


    @Test
    void saveWareHouseAssistantUser_ValidUser_ReturnsUserResponse() {
        // Arrange
        CreateUser createUser = UserFactory.getCreateUser();
        User user = UserFactory.getUser();
        UserResponse userResponse = UserFactory.getUserResponse();

        when(userRequestMapper.toUser(createUser)).thenReturn(user);

        doNothing().when(userServicePort).saveWareHouseAssistantUser(user);

        when(userResponseMapper.userToUserResponse(user)).thenReturn(userResponse);

        // Act
        UserResponse result = userHandler.saveWareHouseAssistantUser(createUser);

        // Assert
        assertEquals(userResponse, result);
        verify(userServicePort, times(1)).saveWareHouseAssistantUser(user);
    }

}
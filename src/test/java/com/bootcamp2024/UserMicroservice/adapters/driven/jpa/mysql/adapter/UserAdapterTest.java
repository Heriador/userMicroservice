package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UserAdapterTest {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserEntityMapper userEntityMapper;

    @InjectMocks
    private UserAdapter userAdapter;


    @Test
    void saveWareHouseAssistantUser_ValidUser_SavesUser() {
        // Arrange
        User user = UserFactory.getUser();
        UserEntity userEntity = UserFactory.getUserEntity();

        when(userEntityMapper.toUserEntity(user)).thenReturn(userEntity);

        // Act
        userAdapter.saveWareHouseAssistantUser(user);

        // Assert
        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    void existsByEmail_EmailExists_ReturnsTrue() {
        // Arrange
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new UserEntity()));

        // Act
        boolean exists = userAdapter.existsByEmail(email);

        // Assert
        assertTrue(exists);
        verify(userRepository, times(1)).findByEmail(email);
    }

}
package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.factory.RoleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class RoleAdapterTest {
    @Mock
    private IRoleRepository roleRepository;

    @Mock
    private IRoleEntityMapper roleEntityMapper;

    @InjectMocks
    private RoleAdapter roleAdapter;

    @BeforeEach
    void setUp() {
        // Initialize mocks
    }

    @Test
    void findByName_ExistingRole_ReturnsRole() {
        // Arrange
        String roleName = "ADMIN";
        RoleEntity roleEntity = RoleFactory.getRoleEntity();
        Role expectedRole = RoleFactory.getRole();

        when(roleRepository.findByName(roleName)).thenReturn(roleEntity);
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(expectedRole);

        // Act
        Role actualRole = roleAdapter.findByName(roleName);

        // Assert
        assertEquals(expectedRole, actualRole);
        verify(roleRepository, times(1)).findByName(roleName);
    }

    @Test
    void findByName_NonExistingRole_ReturnsNull() {
        // Arrange
        String roleName = "NON_EXISTENT_ROLE";

        when(roleRepository.findByName(roleName)).thenReturn(null);

        // Act
        Role actualRole = roleAdapter.findByName(roleName);

        // Assert
        assertNull(actualRole);
        verify(roleRepository, times(1)).findByName(roleName);
    }
}
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
    void getRoleId_ExistingRole_ReturnsRoleId() {
        // Arrange
        String roleName = "ADMIN";
        RoleEntity roleEntity = RoleFactory.getRoleEntity();
        Role expectedRole = RoleFactory.getRole();

        when(roleRepository.findByName(roleName)).thenReturn(roleEntity);

        // Act
        Long actualRoleId = roleAdapter.getRoleId(roleName);

        // Assert
        assertEquals(expectedRole.getId(), actualRoleId);
        verify(roleRepository, times(1)).findByName(roleName);
    }

    @Test
    void getRoleId_NonExistingRole_ReturnsNull() {
        // Arrange
        String roleName = "NON_EXISTENT_ROLE";

        when(roleRepository.findByName(roleName)).thenReturn(null);



        assertThrows(NullPointerException.class, () -> roleAdapter.getRoleId(roleName));

        verify(roleRepository, times(1)).findByName(roleName);
    }

    @Test
    void getRoleName_ExistingRole_ReturnsRole() {
        // Arrange
        Long roleId = 1L;
        RoleEntity roleEntity = RoleFactory.getRoleEntity();
        Role expectedRole = RoleFactory.getRole();

        when(roleRepository.findById(roleId)).thenReturn(java.util.Optional.of(roleEntity));
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(expectedRole);

        // Act
        Role actualRole = roleAdapter.getRoleName(roleId);

        // Assert
        assertEquals(expectedRole, actualRole);
        verify(roleRepository, times(1)).findById(roleId);
    }

    @Test
    void getRoleName_NonExistingRole_ThrowsException() {
        // Arrange
        Long roleId = 1L;

        when(roleRepository.findById(roleId)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(Exception.class, () -> roleAdapter.getRoleName(roleId));

        verify(roleRepository, times(1)).findById(roleId);
    }

}
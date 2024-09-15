package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;
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
class RolUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private RolUseCase rolUseCase;

    @BeforeEach
    void setUp() {
        // Initialize mocks
    }

    @Test
    void getRole_ExistingRole_ReturnsRole() {
        // Arrange
        String roleName = "ADMIN";
        Role expectedRole = RoleFactory.getRole();

        when(rolePersistencePort.getRoleId(roleName)).thenReturn(expectedRole.getId());

        // Act
        Long actualRoleId = rolUseCase.getRoleId(roleName);

        // Assert
        assertEquals(expectedRole.getId(), actualRoleId);
        verify(rolePersistencePort, times(1)).getRoleId(roleName);
    }

    @Test
    void getRole_NonExistingRole_ReturnsNull() {
        // Arrange
        String roleName = "NON_EXISTENT_ROLE";

        when(rolePersistencePort.getRoleId(roleName)).thenReturn(null);

        // Act
        Long actualRoleId = rolUseCase.getRoleId(roleName);

        // Assert
        assertNull(actualRoleId);
        verify(rolePersistencePort, times(1)).getRoleId(roleName);
    }

}
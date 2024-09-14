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

        when(rolePersistencePort.findByName(roleName)).thenReturn(expectedRole);

        // Act
        Role actualRole = rolUseCase.getRole(roleName);

        // Assert
        assertAll(
                () -> assertEquals(expectedRole.getId(), actualRole.getId()),
                () -> assertEquals(expectedRole.getName(), actualRole.getName()),
                () -> assertEquals(expectedRole.getDescription(), actualRole.getDescription())
        );
        verify(rolePersistencePort, times(1)).findByName(roleName);
    }

    @Test
    void getRole_NonExistingRole_ReturnsNull() {
        // Arrange
        String roleName = "NON_EXISTENT_ROLE";

        when(rolePersistencePort.findByName(roleName)).thenReturn(null);

        // Act
        Role actualRole = rolUseCase.getRole(roleName);

        // Assert
        assertNull(actualRole);
        verify(rolePersistencePort, times(1)).findByName(roleName);
    }

}
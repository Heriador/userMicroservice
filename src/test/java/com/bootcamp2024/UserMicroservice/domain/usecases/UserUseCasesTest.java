package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.exception.*;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class UserUseCasesTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCases userUseCases;



    @Test
    void saveWareHouseAssistantUser_UserAlreadyExists_ThrowsException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(true);

        // Act & Assert
        assertThrows(UserAlreadyExistException.class, () -> userUseCases.saveWareHouseAssistantUser(user));

        verify(userPersistencePort, never()).saveWareHouseAssistantUser(any(User.class));
    }

    @Test
    void saveWareHouseAssistantUser_UserDoesNotExist_SavesUser() {
        // Arrange
        User user = new User();
        user.setId(null);
        user.setEmail("test@example.com");
        user.setName("Test");
        user.setLastName("Test");
        user.setIdentityDocument("12345678");
        user.setPhone("+12345678");
        user.setPassword("12345678");
        user.setBirthDate(LocalDate.of(2001,4,22));
        user.setRole(Mockito.mock(Role.class));

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        userUseCases.saveWareHouseAssistantUser(user);

        // Assert
        verify(userPersistencePort, times(1)).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_AgeValidation_ThrowsException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setName("Test");
        user.setLastName("Test");
        user.setIdentityDocument("12345678");
        user.setPhone("12345678");
        user.setPassword("12345678");
        user.setBirthDate(LocalDate.of(2007,4,22));

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(AgeValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_EmailValidation_ThrowsException() {
        // Arrange
        User user = new User();
        user.setEmail("testexample.com");
        user.setName("Test");
        user.setLastName("Test");
        user.setIdentityDocument("12345678");
        user.setPhone("12345678");
        user.setPassword("12345678");
        user.setBirthDate(LocalDate.of(2001,4,22));

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(EmailValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_IdentityDocumentValidation_ThrowsException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setName("Test");
        user.setLastName("Test");
        user.setIdentityDocument("cc12345678");
        user.setPhone("12345678");
        user.setPassword("12345678");
        user.setBirthDate(LocalDate.of(2001,4,22));

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(IdentityDocumentValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_PhoneValidation_ThrowsException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setName("Test");
        user.setLastName("Test");
        user.setIdentityDocument("12345678");
        user.setPhone("+123456789124124");
        user.setPassword("12345678");
        user.setBirthDate(LocalDate.of(2001,4,22));

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(PhoneValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

}
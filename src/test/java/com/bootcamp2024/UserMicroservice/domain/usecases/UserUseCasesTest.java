package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IEncryptionServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.*;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import com.bootcamp2024.UserMicroservice.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class UserUseCasesTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IEncryptionServicePort encryptionServicePort;

    @InjectMocks
    private UserUseCases userUseCases;



    @Test
    void saveWareHouseAssistantUser_UserAlreadyExists_ThrowsException() {
        // Arrange
        User user = UserFactory.getUser();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(true);

        // Act & Assert
        assertThrows(UserAlreadyExistException.class, () -> userUseCases.saveWareHouseAssistantUser(user));

        verify(userPersistencePort, never()).saveWareHouseAssistantUser(any(User.class));
    }

    @Test
    void saveWareHouseAssistantUser_UserDoesNotExist_SavesUser() {
        // Arrange
        User user = UserFactory.getUser();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);
        when(encryptionServicePort.encode(user.getPassword())).thenReturn("encryptedPassword");


        // Act
        userUseCases.saveWareHouseAssistantUser(user);

        // Assert
        verify(userPersistencePort, times(1)).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_AgeValidation_ThrowsException() {
        // Arrange
        User user = UserFactory.userWithInvalidAge();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(AgeValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_EmailValidation_ThrowsException() {
        // Arrange
        User user = UserFactory.userWithInvalidEmail();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(EmailValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_IdentityDocumentValidation_ThrowsException() {
        // Arrange
        User user = UserFactory.userWithInvalidIdentityDocument();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(IdentityDocumentValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

    @Test
    void saveWareHouseAssistantUser_PhoneValidation_ThrowsException() {
        // Arrange
        User user = UserFactory.userWithInvalidPhone();

        when(userPersistencePort.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        assertThrows(PhoneValidationException.class,() ->userUseCases.saveWareHouseAssistantUser(user));

        // Assert
        verify(userPersistencePort, never()).saveWareHouseAssistantUser(user);
    }

}
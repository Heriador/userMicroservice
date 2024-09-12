package com.bootcamp2024.UserMicroservice.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Test
    void testUserBuilder() {
        User user = new User.Builder()
                .id(1L)
                .name("John")
                .lastName("Doe")
                .identityDocument("123456789")
                .phone("+1234567890")
                .email("john.doe@example.com")
                .password("password123")
                .birthDate(LocalDate.of(1990, 1, 1))
                .role(new Role(1L, "USER", null))
                .build();

        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("123456789", user.getIdentityDocument());
        assertEquals("+1234567890", user.getPhone());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(LocalDate.of(1990, 1, 1), user.getBirthDate());
        assertEquals(1L, user.getRole().getId());
        assertEquals("USER", user.getRole().getName());
    }

}
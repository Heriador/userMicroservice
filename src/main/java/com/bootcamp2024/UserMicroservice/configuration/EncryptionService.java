package com.bootcamp2024.UserMicroservice.configuration;

import com.bootcamp2024.UserMicroservice.domain.api.IEncryptionServicePort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptionService implements IEncryptionServicePort {

    private final PasswordEncoder passwordEncoder;


    public EncryptionService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean verify(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}

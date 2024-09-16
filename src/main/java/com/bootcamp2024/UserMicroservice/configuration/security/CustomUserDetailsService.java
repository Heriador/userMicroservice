package com.bootcamp2024.UserMicroservice.configuration.security;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.bootcamp2024.UserMicroservice.configuration.util.AuthenticationConstants;
import com.bootcamp2024.UserMicroservice.domain.exception.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        return userRepository.findByEmail(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new AuthenticationException(AuthenticationConstants.INVALID_CREDENTIALS_EXCEPTION_MESSAGE));
    }

    public UserDetails loadUserById(Long id) {
        return userRepository.findById(id)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new AuthenticationException(AuthenticationConstants.INVALID_CREDENTIALS_EXCEPTION_MESSAGE));
    }
}

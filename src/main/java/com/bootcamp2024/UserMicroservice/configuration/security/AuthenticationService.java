package com.bootcamp2024.UserMicroservice.configuration.security;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        authenticationManager.authenticate(authenticationToken);

        CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(request.getEmail());

        String jwt = jwtService.generateToken(user.getUserEntity(), generateExtraClaims(user));


        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(CustomUserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getUsername());
        claims.put("role", user.getUserEntity().getRole().getName());
        claims.put("authorities", user.getAuthorities());


        return claims;
    }
}

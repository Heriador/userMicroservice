package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.AuthConstants;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.JwtService;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IAuthPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class AuthAdapter implements IAuthPersistencePort {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final IRolePersistencePort rolePersistencePort;

    @Override
    public User authenticate(String email, String password) {
        Authentication authUser = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        CustomUserDetails customUserDetails = (CustomUserDetails) authUser.getPrincipal();

        User user = new User();
        user.setId(customUserDetails.getUserEntity().getId());
        user.setEmail(customUserDetails.getUsername());
        user.setRoleId(customUserDetails.getUserEntity().getRole().getId());

        return user;
    }

    @Override
    public boolean validateCredentials(String email, String password) {

        try {
             Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            return authentication.isAuthenticated();
        } catch (BadCredentialsException e) {
            return false;
        }


    }

    @Override
    public String generateToken(User user) {

        return jwtService.generateToken(user, generateExtraClaims(user));
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        Role role = rolePersistencePort.getRoleName(user.getRoleId());
        extraClaims.put(AuthConstants.AUTHORITIES_KEY, AuthConstants.ROLE_PREFIX+role.getName());


        return extraClaims;
    }
}

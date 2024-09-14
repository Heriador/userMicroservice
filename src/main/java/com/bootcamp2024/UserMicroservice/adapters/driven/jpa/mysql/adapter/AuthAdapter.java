package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.AuthConstants;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.JwtService;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IAuthPersistencePort;
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
    private final IUserEntityMapper userEntityMapper;

    @Override
    public User authenticate(String email, String password) {
        Authentication authUser = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        CustomUserDetails user = (CustomUserDetails) authUser.getPrincipal();

        return userEntityMapper.toUser(user.getUserEntity());
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

        UserEntity userEntity = userEntityMapper.toUserEntity(user);

        return jwtService.generateToken(userEntity, generateExtraClaims(userEntity));
    }

    private Map<String, Object> generateExtraClaims(UserEntity user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put(AuthConstants.EMAIL_KEY, user.getEmail());
        extraClaims.put(AuthConstants.AUTHORITI_KEY, AuthConstants.ROLE_PREFIX+user.getRole().getName());


        return extraClaims;
    }
}

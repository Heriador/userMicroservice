package com.bootcamp2024.UserMicroservice.configuration.security.filter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.CustomUserDetails;
import com.bootcamp2024.UserMicroservice.configuration.security.CustomUserDetailsService;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.util.JwtService;
import com.bootcamp2024.UserMicroservice.configuration.util.AuthenticationConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(AuthenticationConstants.AUTHORIZATION_HEADER);

        if(authHeader == null || !authHeader.startsWith(AuthenticationConstants.BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authHeader.split(" ")[1];

        try{
            if(!jwtService.isValid(jwt)){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, AuthenticationConstants.INVALID_TOKEN_MESSAGE);
                return;
            }

            String username = jwtService.extractUsername(jwt);

            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserById(Long.parseLong(username));

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());


            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        catch(Exception e){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, AuthenticationConstants.INVALID_TOKEN_MESSAGE);
            return;
        }

        filterChain.doFilter(request, response);


    }
}

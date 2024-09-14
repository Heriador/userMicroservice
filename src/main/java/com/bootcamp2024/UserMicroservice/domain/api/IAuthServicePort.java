package com.bootcamp2024.UserMicroservice.domain.api;

public interface IAuthServicePort {
    String login(String email, String password);
}

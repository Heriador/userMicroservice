package com.bootcamp2024.UserMicroservice.domain.spi;

import com.bootcamp2024.UserMicroservice.domain.model.User;

public interface IUserPersistencePort {

//    void saveWareHouseAssistantUser(User user);

    boolean existsByEmail(String email);

    void saveUser(User user);

//    void saveClientUser(User user);
}

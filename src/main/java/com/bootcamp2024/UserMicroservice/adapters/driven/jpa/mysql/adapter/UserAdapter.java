package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveWareHouseAssistantUser(User user) {

        UserEntity userEntity = userEntityMapper.toUserEntity(user);

        userRepository.save(userEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

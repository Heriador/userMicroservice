package com.bootcamp2024.UserMicroservice.configuration.beanConfiguration;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter.RoleAdapter;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.bootcamp2024.UserMicroservice.configuration.EncryptionService;
import com.bootcamp2024.UserMicroservice.domain.api.IEncryptionServicePort;
import com.bootcamp2024.UserMicroservice.domain.api.IRoleServicePort;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistancePort;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.usecases.RolUseCase;
import com.bootcamp2024.UserMicroservice.domain.usecases.UserUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;


    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IEncryptionServicePort encryptionServicePort() {
        return new EncryptionService();
    }



    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCases(userPersistencePort(), encryptionServicePort());
    }

    @Bean
    public IRolePersistancePort rolPersistancePort() {
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }

    @Bean IRoleServicePort roleServicePort() {
        return new RolUseCase(rolPersistancePort());
    }

}

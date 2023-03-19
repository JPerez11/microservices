package com.pragma.foodcourt.infrastructure.configuration;

import com.pragma.foodcourt.domain.api.IUserServicePort;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import com.pragma.foodcourt.domain.usecase.UserUseCase;
import com.pragma.foodcourt.domain.util.IUserPasswordEncrypt;
import com.pragma.foodcourt.infrastructure.impl.UserPasswordEncryptImpl;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder encoder;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, roleRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPasswordEncrypt passwordEncrypt() {
        return new UserPasswordEncryptImpl(encoder);
    }
}
package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.domain.api.dish.ICreateDishServicePort;
import com.pragma.foodcourt.domain.spi.dish.ICreateDishPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.CreateDishUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.CreateDishAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.ICreateDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateDishBean {

    private final IDishRepository dishRepository;
    private final ICreateDishEntityMapper createDishEntityMapper;

    @Bean
    public ICreateDishPersistencePort saveDishPersistencePort() {
        return new CreateDishAdapter(dishRepository, createDishEntityMapper);
    }

    @Bean
    public ICreateDishServicePort saveDishServicePort() {
        return new CreateDishUseCase(saveDishPersistencePort());
    }
}

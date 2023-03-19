package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.domain.api.dish.IUpdateDishServicePort;
import com.pragma.foodcourt.domain.spi.dish.IUpdateDishPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.UpdateDishUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.UpdateDishAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IUpdateDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UpdateDishBean {

    private final IDishRepository dishRepository;
    private final IUpdateDishEntityMapper updateDishEntityMapper;

    @Bean
    public IUpdateDishPersistencePort updateDishPersistencePort() {
        return new UpdateDishAdapter(dishRepository, updateDishEntityMapper);
    }

    @Bean
    public IUpdateDishServicePort updateDishServicePort() {
        return new UpdateDishUseCase(updateDishPersistencePort());
    }

}

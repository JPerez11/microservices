package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.domain.api.dish.IReadDishServicePort;
import com.pragma.foodcourt.domain.spi.dish.IReadDishPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.ReadDishUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.ReadDishAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IReadDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReadDishBean {

    private final IDishRepository dishRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IReadDishEntityMapper readDishEntityMapper;

    @Bean
    public IReadDishPersistencePort readDishPersistencePort() {
        return new ReadDishAdapter(dishRepository, restaurantRepository, readDishEntityMapper);
    }

    @Bean
    public IReadDishServicePort readDishServicePort() {
        return new ReadDishUseCase(readDishPersistencePort());
    }

}

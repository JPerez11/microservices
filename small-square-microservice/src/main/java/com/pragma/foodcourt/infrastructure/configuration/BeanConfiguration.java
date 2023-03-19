package com.pragma.foodcourt.infrastructure.configuration;

import com.pragma.foodcourt.domain.api.restaurant.IRestaurantServicePort;
import com.pragma.foodcourt.domain.spi.restaurant.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.usecase.restaurant.RestaurantUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.restaurant.RestaurantJpaAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.restaurant.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }

}
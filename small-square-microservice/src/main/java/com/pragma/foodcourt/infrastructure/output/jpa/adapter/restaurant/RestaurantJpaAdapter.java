package com.pragma.foodcourt.infrastructure.output.jpa.adapter.restaurant;

import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.restaurant.IRestaurantPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.restaurant.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    @Override
    public RestaurantModel saveRestaurant(RestaurantModel restaurantModel) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(
                restaurantEntityMapper.toRestaurantEntity(restaurantModel));

        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAllOrderByNameAsc();

        if(restaurantEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantModelList(restaurantEntityList);
    }
}

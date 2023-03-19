package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IReadDishPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IReadDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadDishAdapter implements IReadDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IReadDishEntityMapper readDishEntityMapper;

    @Override
    public List<DishModel> findAllDishes() {
        List<DishEntity> dishEntityList = dishRepository.findAll();

        if(dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return readDishEntityMapper.toDishModelList(dishEntityList);
    }

    @Override
    public List<DishModel> findDishByIdRestaurantOrderByIdCategory(Long id) {
        RestaurantEntity restaurantEntity = restaurantRepository
                .findById(id).orElse(null);
        if (restaurantEntity == null) {
            throw new NoDataFoundException();
        }
        List<DishEntity> dishEntityList = dishRepository.findDishByIdRestaurantOrderByIdCategory(restaurantEntity);

        if(dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return readDishEntityMapper.toDishModelList(dishEntityList);
    }
}

package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.api.dish.IReadDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IReadDishPersistencePort;

import java.util.List;

public class ReadDishUseCase implements IReadDishServicePort {

    private final IReadDishPersistencePort readDishPersistencePort;

    public ReadDishUseCase(IReadDishPersistencePort readDishPersistencePort) {
        this.readDishPersistencePort = readDishPersistencePort;
    }

    @Override
    public List<DishModel> findAllDishes() {
        return readDishPersistencePort.findAllDishes();
    }

    @Override
    public List<DishModel> findDishByIdRestaurantOrderByIdCategory(Long id) {
        return readDishPersistencePort.findDishByIdRestaurantOrderByIdCategory(id);
    }
}

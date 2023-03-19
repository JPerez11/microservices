package com.pragma.foodcourt.domain.spi.dish;

import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IReadDishPersistencePort {

    List<DishModel> findAllDishes();

    List<DishModel>  findDishByIdRestaurantOrderByIdCategory(Long id);

}

package com.pragma.foodcourt.domain.api.dish;

import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IReadDishServicePort {

    List<DishModel> findAllDishes();

    List<DishModel>  findDishByIdRestaurantOrderByIdCategory(Long id);

}

package com.pragma.foodcourt.domain.api.dish;

import com.pragma.foodcourt.domain.model.DishModel;

public interface IUpdateDishServicePort {

    DishModel getDish(Long id);

    void updateDish(DishModel dishModel);

}

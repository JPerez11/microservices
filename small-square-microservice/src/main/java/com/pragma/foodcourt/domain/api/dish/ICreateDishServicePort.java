package com.pragma.foodcourt.domain.api.dish;

import com.pragma.foodcourt.domain.model.DishModel;

public interface ICreateDishServicePort {

    void saveDish(DishModel dishModel);

}

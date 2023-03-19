package com.pragma.foodcourt.domain.spi.dish;

import com.pragma.foodcourt.domain.model.DishModel;

public interface ICreateDishPersistencePort {

    DishModel saveDish(DishModel dishModel);

}

package com.pragma.foodcourt.domain.spi.dish;

import com.pragma.foodcourt.domain.model.DishModel;

public interface IUpdateDishPersistencePort {

    DishModel getDish(Long id);

    DishModel updateDish(DishModel dishModel);

}

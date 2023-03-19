package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.api.dish.IUpdateDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IUpdateDishPersistencePort;

public class UpdateDishUseCase implements IUpdateDishServicePort {

    private final IUpdateDishPersistencePort updateDishPersistencePort;

    public UpdateDishUseCase(IUpdateDishPersistencePort updateDishPersistencePort) {
        this.updateDishPersistencePort = updateDishPersistencePort;
    }


    @Override
    public DishModel getDish(Long id) {
        return updateDishPersistencePort.getDish(id);
    }

    @Override
    public void updateDish(DishModel dishModel) {
        updateDishPersistencePort.updateDish(dishModel);
    }
}

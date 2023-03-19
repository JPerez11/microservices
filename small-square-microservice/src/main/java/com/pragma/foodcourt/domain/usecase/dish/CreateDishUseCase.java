package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.api.dish.ICreateDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.ICreateDishPersistencePort;

public class CreateDishUseCase implements ICreateDishServicePort {

    private final ICreateDishPersistencePort createDishPersistencePort;

    public CreateDishUseCase(ICreateDishPersistencePort createDishPersistencePort) {
        this.createDishPersistencePort = createDishPersistencePort;
    }

    @Override
    public void saveDish(DishModel dishModel) {
        createDishPersistencePort.saveDish(dishModel);
    }
}

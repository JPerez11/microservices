package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.ICreateDishPersistencePort;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.ICreateDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateDishAdapter implements ICreateDishPersistencePort {

    private final IDishRepository dishRepository;
    private final ICreateDishEntityMapper createDishEntityMapper;

    @Override
    public DishModel saveDish(DishModel dishModel) {
        DishEntity dishEntity = dishRepository.save(
                createDishEntityMapper.toDishEntity(dishModel));

        return createDishEntityMapper.toDishModel(dishEntity);
    }

}

package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IUpdateDishPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IUpdateDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateDishAdapter implements IUpdateDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IUpdateDishEntityMapper updateDishEntityMapper;

    @Override
    public DishModel getDish(Long id) {
        return updateDishEntityMapper.toDishModel
                (dishRepository.findById(id).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public DishModel updateDish(DishModel dishModel) {
        DishEntity dishEntity = updateDishEntityMapper.toDishEntity(dishModel);

        dishRepository.save(dishEntity);

        return updateDishEntityMapper.toDishModel(dishEntity);
    }
}

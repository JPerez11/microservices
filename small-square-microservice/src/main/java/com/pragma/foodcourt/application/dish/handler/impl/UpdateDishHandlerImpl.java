package com.pragma.foodcourt.application.dish.handler.impl;

import com.pragma.foodcourt.application.dish.dto.request.UpdateDishRequestDto;
import com.pragma.foodcourt.application.dish.dto.request.UpdateDishStatusRequestDto;
import com.pragma.foodcourt.application.dish.dto.response.GetDishForUpdateResponseDto;
import com.pragma.foodcourt.application.dish.handler.IUpdateDishHandler;
import com.pragma.foodcourt.application.dish.mapper.IUpdateDishRequestMapper;
import com.pragma.foodcourt.domain.api.dish.IUpdateDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateDishHandlerImpl implements IUpdateDishHandler {

    private final IUpdateDishServicePort updateDishServicePort;
    private final IUpdateDishRequestMapper updateDishRequestMapper;

    @Override
    public GetDishForUpdateResponseDto getDish(Long id) {
        DishModel dishModel = updateDishServicePort.getDish(id);
        return updateDishRequestMapper.getDishForUpdateResponseDto(dishModel);
    }

    @Override
    public void updateDish(UpdateDishRequestDto updateDishRequestDto) {
        DishModel dishModel = updateDishServicePort.getDish(updateDishRequestDto.getId());

        dishModel.setPrice(updateDishRequestDto.getPrice());
        dishModel.setDescription(updateDishRequestDto.getDescription());

        updateDishServicePort.updateDish(dishModel);
    }

    @Override
    public void updateDishStatus(UpdateDishStatusRequestDto updateDishStatusRequestDto) {
        DishModel dishModel = updateDishServicePort.getDish(updateDishStatusRequestDto.getId());

        dishModel.setActive(updateDishStatusRequestDto.isActive());

        updateDishServicePort.updateDish(dishModel);
    }
}

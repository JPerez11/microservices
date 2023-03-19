package com.pragma.foodcourt.application.dish.handler.impl;

import com.pragma.foodcourt.application.dish.dto.request.SaveDishRequestDto;
import com.pragma.foodcourt.application.dish.handler.ICreateDishHandler;
import com.pragma.foodcourt.application.dish.mapper.ISaveDishRequestMapper;
import com.pragma.foodcourt.domain.api.dish.ICreateDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CreateDishHandlerImpl implements ICreateDishHandler {

    private final ICreateDishServicePort createDishServicePort;
    private final ISaveDishRequestMapper saveDishRequestMapper;

    @Override
    public void saveDish(SaveDishRequestDto saveDishRequestDto) {
        DishModel dishModel = saveDishRequestMapper.toDishModel(saveDishRequestDto);

        createDishServicePort.saveDish(dishModel);
    }
}

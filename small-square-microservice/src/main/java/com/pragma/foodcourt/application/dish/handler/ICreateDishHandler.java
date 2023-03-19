package com.pragma.foodcourt.application.dish.handler;

import com.pragma.foodcourt.application.dish.dto.request.SaveDishRequestDto;

public interface ICreateDishHandler {

    void saveDish(SaveDishRequestDto saveDishRequestDto);

}

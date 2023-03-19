package com.pragma.foodcourt.application.dish.handler;

import com.pragma.foodcourt.application.dish.dto.request.UpdateDishRequestDto;
import com.pragma.foodcourt.application.dish.dto.request.UpdateDishStatusRequestDto;
import com.pragma.foodcourt.application.dish.dto.response.GetDishForUpdateResponseDto;

public interface IUpdateDishHandler {

    GetDishForUpdateResponseDto getDish(Long id);

    void updateDish(UpdateDishRequestDto updateDishRequestDto);

    void updateDishStatus(UpdateDishStatusRequestDto updateDishStatusRequestDto);

}

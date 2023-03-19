package com.pragma.foodcourt.application.dish.handler;

import com.pragma.foodcourt.application.dish.dto.response.ReadDishResponseDto;

import java.util.List;

public interface IReadDishHandler {

    List<ReadDishResponseDto> findAllDish();

    List<ReadDishResponseDto>  findDishByIdRestaurantOrderByIdCategory(Long id);

}

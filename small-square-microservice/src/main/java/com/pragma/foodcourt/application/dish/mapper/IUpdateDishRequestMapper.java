package com.pragma.foodcourt.application.dish.mapper;

import com.pragma.foodcourt.application.dish.dto.request.UpdateDishRequestDto;
import com.pragma.foodcourt.application.dish.dto.response.GetDishForUpdateResponseDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUpdateDishRequestMapper {

    GetDishForUpdateResponseDto getDishForUpdateResponseDto(DishModel dishModel);
    DishModel toDishModel(UpdateDishRequestDto updateDishRequestDto);
    UpdateDishRequestDto toUpdateDishRequestDto(DishModel dishModel);

}

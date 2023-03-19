package com.pragma.foodcourt.application.dish.mapper;

import com.pragma.foodcourt.application.dish.dto.request.SaveDishRequestDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISaveDishRequestMapper {

    DishModel toDishModel(SaveDishRequestDto saveDishRequestDto);

}

package com.pragma.foodcourt.application.dish.mapper;

import com.pragma.foodcourt.application.dish.dto.response.ReadDishResponseDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IReadDishResponseMapper {

    ReadDishResponseDto toDishResponse(DishModel dishModel);

    List<ReadDishResponseDto> dishResponseList(List<DishModel> dishModelList);

}

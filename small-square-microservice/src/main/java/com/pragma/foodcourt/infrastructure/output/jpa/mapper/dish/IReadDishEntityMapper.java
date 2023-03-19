package com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IReadDishEntityMapper {

    List<DishModel> toDishModelList(List<DishEntity> dishEntityList);

}

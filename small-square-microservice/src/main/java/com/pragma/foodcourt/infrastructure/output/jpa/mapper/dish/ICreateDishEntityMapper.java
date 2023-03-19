package com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICreateDishEntityMapper {

    DishModel toDishModel(DishEntity dishEntity);

    DishEntity toDishEntity(DishModel dishModel);

}

package com.pragma.foodcourt.infrastructure.output.jpa.mapper.restaurant;

import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toRestaurantEntity(RestaurantModel restaurantModel);

    RestaurantModel toRestaurantModel(RestaurantEntity restaurantEntity);

    List<RestaurantModel> toRestaurantModelList(List<RestaurantEntity> restaurantEntityList);
}

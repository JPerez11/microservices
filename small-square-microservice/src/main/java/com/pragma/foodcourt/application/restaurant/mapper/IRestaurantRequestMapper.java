package com.pragma.foodcourt.application.restaurant.mapper;

import com.pragma.foodcourt.application.restaurant.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    RestaurantModel toRestaurantModel(RestaurantRequestDto restaurantRequestDto);
}

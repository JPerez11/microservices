package com.pragma.foodcourt.application.restaurant.mapper;

import com.pragma.foodcourt.application.restaurant.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toRestaurantResponse(RestaurantModel restaurantModel);

    List<RestaurantResponseDto> restaurantResponseList(List<RestaurantModel> restaurantModelList);

}

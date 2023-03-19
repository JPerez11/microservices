package com.pragma.foodcourt.application.restaurant.handler;

import com.pragma.foodcourt.application.restaurant.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.restaurant.dto.response.RestaurantResponseDto;

import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);

    List<RestaurantResponseDto> getAllRestaurants();
}

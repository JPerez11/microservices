package com.pragma.foodcourt.application.restaurant.handler.impl;

import com.pragma.foodcourt.application.restaurant.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.restaurant.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.application.restaurant.handler.IRestaurantHandler;
import com.pragma.foodcourt.application.restaurant.mapper.IRestaurantRequestMapper;
import com.pragma.foodcourt.application.restaurant.mapper.IRestaurantResponseMapper;
import com.pragma.foodcourt.domain.api.restaurant.IRestaurantServicePort;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantHandlerImpl implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        RestaurantModel restaurantModel = restaurantRequestMapper.toRestaurantModel(
                restaurantRequestDto);

        restaurantServicePort.saveRestaurant(restaurantModel);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.restaurantResponseList(
                restaurantServicePort.getAllRestaurants());
    }
}

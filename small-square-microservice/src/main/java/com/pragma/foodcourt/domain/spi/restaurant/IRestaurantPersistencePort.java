package com.pragma.foodcourt.domain.spi.restaurant;

import com.pragma.foodcourt.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantPersistencePort {

    RestaurantModel saveRestaurant(RestaurantModel restaurantModel);

    List<RestaurantModel> getAllRestaurants();

}

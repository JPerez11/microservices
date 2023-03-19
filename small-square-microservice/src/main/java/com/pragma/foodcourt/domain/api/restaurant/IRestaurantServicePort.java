package com.pragma.foodcourt.domain.api.restaurant;

import com.pragma.foodcourt.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantServicePort {

    void saveRestaurant(RestaurantModel restaurantModel);

    List<RestaurantModel> getAllRestaurants();

}

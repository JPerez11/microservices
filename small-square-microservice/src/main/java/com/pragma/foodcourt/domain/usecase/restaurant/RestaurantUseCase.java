package com.pragma.foodcourt.domain.usecase.restaurant;

import com.pragma.foodcourt.domain.api.restaurant.IRestaurantServicePort;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.restaurant.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.validation.ValidationRestaurant;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurantModel) {
        ValidationRestaurant validations = new ValidationRestaurant();
        restaurantPersistencePort.saveRestaurant(validations.validationsModel(restaurantModel));
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return restaurantPersistencePort.getAllRestaurants();
    }
}

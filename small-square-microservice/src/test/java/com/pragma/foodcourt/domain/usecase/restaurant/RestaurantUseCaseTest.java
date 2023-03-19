package com.pragma.foodcourt.domain.usecase.restaurant;

import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.restaurant.IRestaurantPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RestaurantUseCaseTest {

    @Mock
    IRestaurantPersistencePort restaurantPersistencePort;

    @InjectMocks
    RestaurantUseCase restaurantUseCase;

    @Test
    void ShouldSaveRestaurant() {
        //Given
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setName("Restaurant");
        restaurantModel.setNit(123456789);
        restaurantModel.setAddress("# 10 - 01");
        restaurantModel.setPhone("+123456789");
        restaurantModel.setUrlLogo("http://logo.png");
        restaurantModel.setIdOwner(3L);

        //When
        Mockito.when(restaurantPersistencePort
                        .saveRestaurant(restaurantModel)).thenReturn(restaurantModel);
        restaurantUseCase.saveRestaurant(restaurantModel);

        //Then
        Mockito.verify(restaurantPersistencePort).saveRestaurant(restaurantModel);
    }

    @Test
    void ShouldReadRestaurant() {
        //Given
        List<RestaurantModel> restaurantModelList = new ArrayList<>();
        RestaurantModel restaurantModel1 = new RestaurantModel();
        restaurantModel1.setId(1L);
        restaurantModel1.setName("Restaurant 1");
        restaurantModel1.setNit(123456789);
        restaurantModel1.setAddress("# 10 - 01");
        restaurantModel1.setPhone("+123456789");
        restaurantModel1.setUrlLogo("http://logo.png");
        restaurantModel1.setIdOwner(3L);

        RestaurantModel restaurantModel2 = new RestaurantModel();
        restaurantModel2.setId(2L);
        restaurantModel2.setName("Restaurant 2");
        restaurantModel2.setNit(987654321);
        restaurantModel2.setAddress("# 20 - 02");
        restaurantModel2.setPhone("+123456789");
        restaurantModel2.setUrlLogo("http://logo.png");
        restaurantModel2.setIdOwner(3L);

        restaurantModelList.add(restaurantModel1);
        restaurantModelList.add(restaurantModel2);
        //When
        Mockito.when(restaurantPersistencePort.getAllRestaurants()).thenReturn(restaurantModelList);
        List<RestaurantModel> result = restaurantUseCase.getAllRestaurants();
        //Then
        assertEquals(2, result.size());
        assertEquals("Restaurant 1", result.get(0).getName());
        assertEquals("Restaurant 2", result.get(1).getName());
        //Verify
        Mockito.verify(restaurantPersistencePort).getAllRestaurants();
    }
}
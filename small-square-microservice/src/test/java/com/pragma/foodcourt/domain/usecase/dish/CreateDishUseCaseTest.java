package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.dish.ICreateDishPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CreateDishUseCaseTest {

    @Mock
    ICreateDishPersistencePort createDishPersistencePort;

    @InjectMocks
    CreateDishUseCase createDishUseCase;

    @Test
    void shouldCreateDish() {
        //Given
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setName("Restaurant 1");
        restaurantModel.setNit(123456789);
        restaurantModel.setAddress("# 10 - 01");
        restaurantModel.setPhone("+123456789");
        restaurantModel.setUrlLogo("http://logo.png");
        restaurantModel.setIdOwner(3L);

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(1L);
        categoryModel.setName("Category 1");
        categoryModel.setDescription("Category test");

        DishModel dishModel = new DishModel();
        dishModel.setId(1L);
        dishModel.setName("Dish 1");
        dishModel.setPrice(1000);
        dishModel.setDescription("Dish test");
        dishModel.setUrlImage("http://dish.png");
        dishModel.setActive(true);
        dishModel.setIdRestaurant(restaurantModel);
        dishModel.setIdCategory(categoryModel);

        //When
        Mockito.when(createDishPersistencePort.saveDish(dishModel)).thenReturn(dishModel);
        createDishUseCase.saveDish(dishModel);

        //Then
        Mockito.verify(createDishPersistencePort).saveDish(dishModel);
    }

}
package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.dish.IUpdateDishPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UpdateDishUseCaseTest {

    @Mock
    IUpdateDishPersistencePort updateDishPersistencePort;

    @InjectMocks
    UpdateDishUseCase updateDishUseCase;

    @Test
    void shouldGetDish() {
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
        Mockito.when(updateDishPersistencePort.getDish(Mockito.anyLong())).thenReturn(dishModel);
        DishModel result = updateDishUseCase.getDish(Mockito.anyLong());

        //Then
        assertNotNull(result, "The result doesn't null");
        assertSame(dishModel, result);
        assertEquals(dishModel.getId(), result.getId());
        assertEquals(dishModel.getIdRestaurant().getId(), result.getIdRestaurant().getId());
        assertEquals(dishModel.getIdRestaurant().getIdOwner(), result.getIdRestaurant().getIdOwner());
        assertEquals(dishModel.getIdCategory().getId(), result.getIdCategory().getId());
        assertEquals(dishModel.getIdCategory().getName(), result.getIdCategory().getName());
        assertEquals(dishModel.getIdCategory().getDescription(), result.getIdCategory().getDescription());

        //Verify
        Mockito.verify(updateDishPersistencePort).getDish(Mockito.anyLong());
    }

    @Test
    void shouldUpdateDish() {
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
        Mockito.when(updateDishPersistencePort.updateDish(dishModel))
                .thenReturn(dishModel);
        updateDishUseCase.updateDish(dishModel);

        //Then
        Mockito.verify(updateDishPersistencePort).updateDish(dishModel);
    }

}
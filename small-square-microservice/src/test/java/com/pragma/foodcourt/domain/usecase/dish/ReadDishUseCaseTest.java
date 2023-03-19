package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.dish.IReadDishPersistencePort;
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
class ReadDishUseCaseTest {

    @Mock
    IReadDishPersistencePort readDishPersistencePort;

    @InjectMocks
    ReadDishUseCase readDishUseCase;

    @Test
    void shouldFindAllDishes() {
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

        List<DishModel> dishModelList = new ArrayList<>();
        dishModelList.add(dishModel);

        //When
        Mockito.when(readDishPersistencePort.findAllDishes()).thenReturn(dishModelList);
        List<DishModel> result = readDishUseCase.findAllDishes();

        //Then
        assertEquals("Dish 1", result.get(0).getName());
        assertEquals(1000, result.get(0).getPrice());
        assertEquals("Dish test", result.get(0).getDescription());
        assertNotEquals("Dish 1", result.get(0).getUrlImage());
        assertTrue(result.get(0).isActive());
        assertEquals(restaurantModel, result.get(0).getIdRestaurant());
        assertEquals(categoryModel, result.get(0).getIdCategory());

        //Verify
        Mockito.verify(readDishPersistencePort).findAllDishes();
    }

    @Test
    void shouldFindDishByIdRestaurantOrderByIdCategory() {
        //Given
        RestaurantModel restaurantModel = new RestaurantModel(1L,
                "Restaurant 1",
                123456789,
                "# 10 - 01",
                "+123456789",
                "http://logo.png",
                3L);

        CategoryModel categoryModel = new CategoryModel(1L,
                "Category 1",
                "Category test");

        DishModel dishModel = new DishModel(1L,
                "Dish 1",
                1000,
                "Dish test",
                "http://dish.png",
                true,
                restaurantModel,
                categoryModel);

        List<DishModel> dishModelList = new ArrayList<>();
        dishModelList.add(dishModel);

        //When
        Mockito.when(readDishPersistencePort.findDishByIdRestaurantOrderByIdCategory(Mockito.anyLong()))
                .thenReturn(dishModelList);
        List<DishModel> result = readDishUseCase.findDishByIdRestaurantOrderByIdCategory(Mockito.anyLong());

        //Then
        assertEquals(dishModelList, result);

        //Verify
        Mockito.verify(readDishPersistencePort).findDishByIdRestaurantOrderByIdCategory(Mockito.anyLong());

    }

}
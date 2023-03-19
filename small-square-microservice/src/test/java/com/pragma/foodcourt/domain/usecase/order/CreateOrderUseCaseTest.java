package com.pragma.foodcourt.domain.usecase.order;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.order.ICreateOrderPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CreateOrderUseCaseTest {

    @Mock
    ICreateOrderPersistencePort createOrderPersistencePort;

    @InjectMocks
    CreateOrderUseCase createOrderUseCase;

    @Test
    void shouldCreateOrder() {
        //Given
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setName("Restaurant 1");
        restaurantModel.setNit(123456789);
        restaurantModel.setAddress("# 10 - 01");
        restaurantModel.setPhone("+123456789");
        restaurantModel.setUrlLogo("http://logo.png");
        restaurantModel.setIdOwner(3L);

        OrderModel orderModel = new OrderModel();
        orderModel.setId(1L);
        orderModel.setIdClient(10L);
        orderModel.setDate(LocalDateTime.now());
        orderModel.setStatus("PENDING");
        orderModel.setIdChef(5L);
        orderModel.setIdRestaurant(restaurantModel);

        //When
        Mockito.when(createOrderPersistencePort.createOrder(orderModel)).thenReturn(orderModel);
        createOrderUseCase.createOrder(orderModel);

        //Then
        Mockito.verify(createOrderPersistencePort).createOrder(orderModel);
    }

    @Test
    void shouldCreateDishOrder() {
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

        OrderModel orderModel = new OrderModel();
        orderModel.setId(1L);
        orderModel.setIdClient(10L);
        orderModel.setDate(LocalDateTime.now());
        orderModel.setStatus("PENDING");
        orderModel.setIdChef(5L);
        orderModel.setIdRestaurant(restaurantModel);

        DishOrderModel dishOrderModel = new DishOrderModel();
        dishOrderModel.setId(1L);
        dishOrderModel.setOrderModel(orderModel);
        dishOrderModel.setDishModel(dishModel);
        dishOrderModel.setAmount(1);

        //When
        Mockito.when(createOrderPersistencePort.createDishOrder(dishOrderModel)).thenReturn(dishOrderModel);
        createOrderUseCase.createDishOrder(dishOrderModel);

        //Then
        Mockito.verify(createOrderPersistencePort).createDishOrder(dishOrderModel);
    }

}
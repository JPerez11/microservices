package com.pragma.foodcourt.domain.usecase.order;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.domain.spi.order.IReadOrderPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ReadOrderUseCaseTest {

    @Mock
    IReadOrderPersistencePort readOrderPersistencePort;

    @InjectMocks
    ReadOrderUseCase readOrderUseCase;

    @Test
    void shouldListOrder() {
        //Given
        RestaurantModel restaurantModel = new RestaurantModel(1L,
                "Restaurant 1",
                123456789,
                "# 10 - 01",
                "+123456789",
                "http://logo.png",
                3L);

        OrderModel orderModel = new OrderModel(1L,
                10L,
                LocalDateTime.now(),
                "PENDING",
                5L,
                restaurantModel);


        List<OrderModel> expected = new ArrayList<>();
        expected.add(orderModel);

        //When
        Mockito.when(readOrderPersistencePort.listOrder()).thenReturn(expected);
        List<OrderModel> actual = readOrderUseCase.listOrder();

        //Then
        assertEquals(expected, actual);
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getIdClient(), actual.get(0).getIdClient());
        assertEquals(expected.get(0).getIdChef(), actual.get(0).getIdChef());
        assertEquals(expected.get(0).getDate(), actual.get(0).getDate());
        assertEquals(expected.get(0).getStatus(), actual.get(0).getStatus());
        assertEquals(expected.get(0).getIdRestaurant(), actual.get(0).getIdRestaurant());

        //Verify
        Mockito.verify(readOrderPersistencePort).listOrder();
    }

    @Test
    void shouldListDishOrder() {
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

        List<DishOrderModel> expected = new ArrayList<>();
        expected.add(dishOrderModel);

        //When
        Mockito.when(readOrderPersistencePort.listDishOrder()).thenReturn(expected);
        List<DishOrderModel> actual = readOrderUseCase.listDishOrder();

        //Then
        Mockito.verify(readOrderPersistencePort).listDishOrder();
    }

    @Test
    void shouldGetOrder() {
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

        OrderModel orderModel = new OrderModel(1L,
                10L,
                LocalDateTime.now(),
                "PENDING",
                5L,
                restaurantModel);

        DishOrderModel dishOrderModel = new DishOrderModel(1L,
                orderModel,
                dishModel,
                1);

        List<DishOrderModel> expected = new ArrayList<>();
        expected.add(dishOrderModel);

        //When
        Mockito.when(readOrderPersistencePort.getOrder(Mockito.anyString(), Mockito.anyLong())).thenReturn(expected);
        List<DishOrderModel> actual = readOrderUseCase.getOrder(Mockito.anyString(), Mockito.anyLong());

        //Then
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getOrderModel(), actual.get(0).getOrderModel());
        assertEquals(expected.get(0).getDishModel(), actual.get(0).getDishModel());
        assertEquals(expected.get(0).getAmount(), actual.get(0).getAmount());

        //Verify
        Mockito.verify(readOrderPersistencePort).getOrder(Mockito.anyString(), Mockito.anyLong());
    }

}
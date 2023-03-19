package com.pragma.foodcourt.domain.spi.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;

import java.util.List;

public interface IReadOrderPersistencePort {

    List<OrderModel> listOrder();

    List<DishOrderModel> listDishOrder();

    List<DishOrderModel> getOrder(String status, Long idRestaurant);

}

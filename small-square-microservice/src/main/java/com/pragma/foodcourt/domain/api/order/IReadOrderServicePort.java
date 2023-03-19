package com.pragma.foodcourt.domain.api.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;

import java.util.List;

public interface IReadOrderServicePort {

    List<OrderModel> listOrder();

    List<DishOrderModel> listDishOrder();

    List<DishOrderModel> getOrder(String status, Long idRestaurant);

}

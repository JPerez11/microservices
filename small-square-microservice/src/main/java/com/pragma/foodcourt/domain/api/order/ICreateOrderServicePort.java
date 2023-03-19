package com.pragma.foodcourt.domain.api.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;

public interface ICreateOrderServicePort {

    void createOrder(OrderModel orderModel);

    void createDishOrder(DishOrderModel dishOrderModel);

}

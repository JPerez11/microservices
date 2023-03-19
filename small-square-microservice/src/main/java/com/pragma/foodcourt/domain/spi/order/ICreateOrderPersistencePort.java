package com.pragma.foodcourt.domain.spi.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;

public interface ICreateOrderPersistencePort {

    OrderModel createOrder(OrderModel orderModel);

    DishOrderModel createDishOrder(DishOrderModel dishOrderModel);

}

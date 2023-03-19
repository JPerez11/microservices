package com.pragma.foodcourt.application.order.handler;

import com.pragma.foodcourt.application.order.dto.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.request.CreateOrderRequestDto;

public interface ICreateOrderHandler {

    void createOrder(CreateOrderRequestDto createOrderRequestDto);

    void createDishOrder(CreateDishOrderRequestDto createDishOrderRequestDto);

}

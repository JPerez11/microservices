package com.pragma.foodcourt.application.order.mapper;

import com.pragma.foodcourt.application.order.dto.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.request.CreateOrderRequestDto;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import org.springframework.stereotype.Component;

@Component
public interface ICreateOrderRequestMapper {

    OrderModel toOrderModel(CreateOrderRequestDto createOrderRequestDto);

    DishOrderModel toDishOrderModel(CreateDishOrderRequestDto createDishOrderRequestDto);

}

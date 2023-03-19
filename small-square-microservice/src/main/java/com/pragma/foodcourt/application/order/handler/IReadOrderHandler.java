package com.pragma.foodcourt.application.order.handler;

import com.pragma.foodcourt.application.order.dto.response.OrderResponse;
import com.pragma.foodcourt.application.order.dto.response.ReadDishOrderResponseDto;
import com.pragma.foodcourt.application.order.dto.response.ReadOrderResponseDto;

import java.util.List;

public interface IReadOrderHandler {

    List<ReadOrderResponseDto> readOrder();

    List<ReadDishOrderResponseDto> readDishOrder();

    List<OrderResponse> getOrder(String status, Long idRestaurant);

}

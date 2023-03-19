package com.pragma.foodcourt.application.order.mapper;

import com.pragma.foodcourt.application.order.dto.response.ReadDishOrderResponseDto;
import com.pragma.foodcourt.application.order.dto.response.ReadOrderResponseDto;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReadOrderResponseMapper {

    ReadOrderResponseDto toOrderResponse(OrderModel orderModel);

    ReadDishOrderResponseDto toDishOrderResponse(DishOrderModel dishOrderModel);

    List<ReadOrderResponseDto> toReadOrderResponseList(List<OrderModel> orderModelList);

    List<ReadDishOrderResponseDto> toReadDishOrderResponseList(
            List<DishOrderModel> dishOrderModelList);

}

package com.pragma.foodcourt.application.order.handler.impl;

import com.pragma.foodcourt.application.order.dto.response.OrderResponse;
import com.pragma.foodcourt.application.order.dto.response.ReadDishOrderResponseDto;
import com.pragma.foodcourt.application.order.dto.response.ReadOrderResponseDto;
import com.pragma.foodcourt.application.order.handler.IReadOrderHandler;
import com.pragma.foodcourt.application.order.mapper.IReadOrderResponseMapper;
import com.pragma.foodcourt.domain.api.order.IReadOrderServicePort;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadOrderHandlerImpl implements IReadOrderHandler {

    private final IReadOrderServicePort readOrderServicePort;
    private final IReadOrderResponseMapper readOrderResponseMapper;

    @Override
    public List<ReadOrderResponseDto> readOrder() {
        return readOrderResponseMapper.toReadOrderResponseList( readOrderServicePort.listOrder() );
    }

    @Override
    public List<ReadDishOrderResponseDto> readDishOrder() {
        return readOrderResponseMapper.toReadDishOrderResponseList( readOrderServicePort.listDishOrder() );
    }

    @Override
    public List<OrderResponse> getOrder(String status, Long idRestaurant) {
        List<DishOrderModel> orderModelList = readOrderServicePort
                .getOrder(status, idRestaurant);
        if (orderModelList.isEmpty()) {
            throw new NoDataFoundException();
        }
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (DishOrderModel dishOrder : orderModelList) {
            ReadOrderResponseDto readOrderResponseDto = readOrderResponseMapper
                    .toOrderResponse( dishOrder.getOrderModel() );
            ReadDishOrderResponseDto readDishOrderResponseDto = readOrderResponseMapper
                    .toDishOrderResponse( dishOrder );

            OrderResponse orderDetails = new OrderResponse(
                    readOrderResponseDto, readDishOrderResponseDto);
            orderResponseList.add(orderDetails);
        }

        return orderResponseList;
    }
}

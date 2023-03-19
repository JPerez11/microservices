package com.pragma.foodcourt.application.order.handler.impl;

import com.pragma.foodcourt.application.order.dto.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.request.CreateOrderRequestDto;
import com.pragma.foodcourt.application.order.handler.ICreateOrderHandler;
import com.pragma.foodcourt.application.order.mapper.ICreateOrderRequestMapper;
import com.pragma.foodcourt.domain.api.order.ICreateOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateOrderHandlerImpl implements ICreateOrderHandler {

    private final ICreateOrderServicePort createOrderServicePort;
    private final ICreateOrderRequestMapper createOrderRequestMapper;

    @Override
    public void createOrder(CreateOrderRequestDto createOrderRequestDto) {
        createOrderServicePort.createOrder(createOrderRequestMapper.
                toOrderModel(createOrderRequestDto));
    }

    @Override
    public void createDishOrder(CreateDishOrderRequestDto createDishOrderRequestDto) {
        createOrderServicePort.createDishOrder(createOrderRequestMapper.
                toDishOrderModel(createDishOrderRequestDto));
    }
}

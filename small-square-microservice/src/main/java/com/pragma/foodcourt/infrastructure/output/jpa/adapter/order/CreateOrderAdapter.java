package com.pragma.foodcourt.infrastructure.output.jpa.adapter.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.spi.order.ICreateOrderPersistencePort;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IDishOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderAdapter implements ICreateOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IDishOrderRepository dishOrderRepository;
    private final IOrderEntityMapper orderEntityMapper;
    private final IDishOrderEntityMapper dishOrderEntityMapper;

    @Override
    public OrderModel createOrder(OrderModel orderModel) {
        OrderEntity order = orderRepository.save(orderEntityMapper.toOrderEntity(orderModel));
        return orderEntityMapper.toOrderModel(order);
    }

    @Override
    public DishOrderModel createDishOrder(DishOrderModel dishOrderModel) {
        DishOrderEntity dishOrder = dishOrderRepository.save(dishOrderEntityMapper.toDishOrderEntity(dishOrderModel));
        return dishOrderEntityMapper.toDishOrderModel(dishOrder);
    }
}

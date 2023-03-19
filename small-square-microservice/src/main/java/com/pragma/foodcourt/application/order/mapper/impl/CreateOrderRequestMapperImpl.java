package com.pragma.foodcourt.application.order.mapper.impl;

import com.pragma.foodcourt.application.order.dto.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.request.CreateOrderRequestDto;
import com.pragma.foodcourt.application.order.mapper.ICreateOrderRequestMapper;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.restaurant.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.ICreateDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderRequestMapperImpl implements ICreateOrderRequestMapper {

    private final IRestaurantRepository restaurantRepository;
    private final IOrderRepository orderRepository;
    private final IDishRepository dishRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IOrderEntityMapper orderEntityMapper;
    private final ICreateDishEntityMapper createDishEntityMapper;

    @Override
    public OrderModel toOrderModel(CreateOrderRequestDto createOrderRequestDto) {

        OrderModel orderModel = new OrderModel();
        Long id = createOrderRequestDto.getIdRestaurant();

        orderModel.setIdClient( createOrderRequestDto.getIdClient() );
        orderModel.setDate( createOrderRequestDto.getDate() );
        orderModel.setStatus(createOrderRequestDto.getStatus() );
        orderModel.setIdChef( createOrderRequestDto.getIdChef() );
        orderModel.setIdRestaurant(
                restaurantEntityMapper.toRestaurantModel(
                        restaurantRepository.findById(id).orElseThrow()
                )
        );

        return orderModel;
    }

    @Override
    public DishOrderModel toDishOrderModel(CreateDishOrderRequestDto createDishOrderRequestDto) {

        DishOrderModel dishOrderModel = new DishOrderModel();
        Long idOrder = createDishOrderRequestDto.getIdOrder();
        Long idDish = createDishOrderRequestDto.getIdDish();

        dishOrderModel.setOrderModel(
                orderEntityMapper.toOrderModel(
                        orderRepository.findById(idOrder).orElseThrow())
        );
        dishOrderModel.setDishModel(
                createDishEntityMapper.toDishModel(
                        dishRepository.findById(idDish).orElseThrow())
        );
        dishOrderModel.setAmount( createDishOrderRequestDto.getAmount() );

        return dishOrderModel;
    }
}

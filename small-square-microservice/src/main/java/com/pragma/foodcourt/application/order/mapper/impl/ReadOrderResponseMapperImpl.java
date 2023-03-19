package com.pragma.foodcourt.application.order.mapper.impl;

import com.pragma.foodcourt.application.order.dto.response.ReadDishOrderResponseDto;
import com.pragma.foodcourt.application.order.dto.response.ReadOrderResponseDto;
import com.pragma.foodcourt.application.order.mapper.IReadOrderResponseMapper;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ReadOrderResponseMapperImpl implements IReadOrderResponseMapper {

    @Override
    public ReadOrderResponseDto toOrderResponse(OrderModel orderModel) {

        if ( orderModel == null) {
            return null;
        }

        ReadOrderResponseDto readOrderResponseDto = new ReadOrderResponseDto();

        readOrderResponseDto.setIdClient( orderModel.getIdClient() );
        readOrderResponseDto.setDate( orderModel.getDate() );
        readOrderResponseDto.setStatus( orderModel.getStatus() );

        return readOrderResponseDto;
    }

    @Override
    public ReadDishOrderResponseDto toDishOrderResponse(DishOrderModel dishOrderModel) {
        if ( dishOrderModel == null ) {
            return null;
        }

        ReadDishOrderResponseDto readDishOrderResponseDto = new ReadDishOrderResponseDto();

        readDishOrderResponseDto.setDishName( dishOrderModel.getDishModel().getName() );
        readDishOrderResponseDto.setDescription( dishOrderModel.getDishModel().getDescription() );
        readDishOrderResponseDto.setUrlImage( dishOrderModel.getDishModel().getUrlImage() );
        readDishOrderResponseDto.setPrice( dishOrderModel.getDishModel().getPrice() );
        readDishOrderResponseDto.setActive( dishOrderModel.getDishModel().isActive() );
        readDishOrderResponseDto.setAmount( dishOrderModel.getAmount() );

        return readDishOrderResponseDto;
    }

    @Override
    public List<ReadOrderResponseDto> toReadOrderResponseList(List<OrderModel> orderModelList) {
        if ( orderModelList == null ) {
            return Collections.emptyList();
        }

        List<ReadOrderResponseDto> list = new ArrayList<>( orderModelList.size() );

        for (OrderModel orderModel :
                orderModelList) {
            list.add( toOrderResponse(orderModel) );
        }

        return list;
    }

    @Override
    public List<ReadDishOrderResponseDto> toReadDishOrderResponseList(List<DishOrderModel> dishOrderModelList) {
        if ( dishOrderModelList == null ) {
            return Collections.emptyList();
        }

        List<ReadDishOrderResponseDto> list = new ArrayList<>( dishOrderModelList.size() );

        for (DishOrderModel dishOrderModel:
             dishOrderModelList) {
            list.add( toDishOrderResponse(dishOrderModel) );
        }
        
        return list;
    }

}

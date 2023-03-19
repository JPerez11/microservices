package com.pragma.foodcourt.infrastructure.output.jpa.mapper.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReadOrderEntityMapper {

    List<OrderModel> toOrderModelList(List<OrderEntity> orderEntities);

    List<DishOrderModel> toDishOrderModelList(List<DishOrderEntity> orderEntities);

}

package com.pragma.foodcourt.infrastructure.output.jpa.mapper.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import org.springframework.stereotype.Component;

@Component
public interface IDishOrderEntityMapper {

    DishOrderEntity toDishOrderEntity(DishOrderModel dishOrderModel);

    DishOrderModel toDishOrderModel(DishOrderEntity dishOrderEntity);

}

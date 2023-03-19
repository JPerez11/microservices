package com.pragma.foodcourt.infrastructure.output.jpa.mapper.order;

import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {

    OrderEntity toOrderEntity(OrderModel orderModel);

    OrderModel toOrderModel(OrderEntity orderEntity);

}

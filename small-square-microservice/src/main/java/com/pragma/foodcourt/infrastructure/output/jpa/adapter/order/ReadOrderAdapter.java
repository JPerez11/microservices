package com.pragma.foodcourt.infrastructure.output.jpa.adapter.order;


import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.spi.order.IReadOrderPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IReadOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadOrderAdapter implements IReadOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IDishOrderRepository dishOrderRepository;
    private final IReadOrderEntityMapper readOrderEntityMapper;


    @Override
    public List<OrderModel> listOrder() {

        List<OrderEntity> orderEntityList = orderRepository.findAll();

        if (orderEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return readOrderEntityMapper.toOrderModelList(orderEntityList);
    }

    @Override
    public List<DishOrderModel> listDishOrder() {

        List<DishOrderEntity> dishOrderEntityList = dishOrderRepository.findAll();

        if (dishOrderEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return readOrderEntityMapper.toDishOrderModelList(dishOrderEntityList);
    }

    @Override
    public List<DishOrderModel> getOrder(String status, Long idRestaurant) {
        List<DishOrderEntity> dishOrderEntityList = dishOrderRepository
                .findAllByOrderEntityStatusAndOrderEntityIdRestaurantId(
                        status, idRestaurant);

        return readOrderEntityMapper.toDishOrderModelList(dishOrderEntityList);
    }

}

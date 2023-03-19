package com.pragma.foodcourt.domain.usecase.order;

import com.pragma.foodcourt.domain.api.order.IReadOrderServicePort;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.spi.order.IReadOrderPersistencePort;

import java.util.List;

public class ReadOrderUseCase implements IReadOrderServicePort {

    private final IReadOrderPersistencePort readOrderPersistencePort;

    public ReadOrderUseCase(IReadOrderPersistencePort readOrderPersistencePort) {
        this.readOrderPersistencePort = readOrderPersistencePort;
    }

    @Override
    public List<OrderModel> listOrder() {
        return readOrderPersistencePort.listOrder();
    }

    @Override
    public List<DishOrderModel> listDishOrder() {
        return readOrderPersistencePort.listDishOrder();
    }

    @Override
    public List<DishOrderModel> getOrder(String status, Long idRestaurant) {
        return readOrderPersistencePort.getOrder(status, idRestaurant);
    }
}

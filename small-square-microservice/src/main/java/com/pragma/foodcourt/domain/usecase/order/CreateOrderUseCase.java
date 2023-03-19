package com.pragma.foodcourt.domain.usecase.order;

import com.pragma.foodcourt.domain.api.order.ICreateOrderServicePort;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.spi.order.ICreateOrderPersistencePort;

public class CreateOrderUseCase implements ICreateOrderServicePort {

    private final ICreateOrderPersistencePort createOrderPersistencePort;

    public CreateOrderUseCase(ICreateOrderPersistencePort createOrderPersistencePort) {
        this.createOrderPersistencePort = createOrderPersistencePort;
    }

    @Override
    public void createOrder(OrderModel orderModel) {
        createOrderPersistencePort.createOrder(orderModel);
    }

    @Override
    public void createDishOrder(DishOrderModel dishOrderModel) {
        createOrderPersistencePort.createDishOrder(dishOrderModel);
    }
}

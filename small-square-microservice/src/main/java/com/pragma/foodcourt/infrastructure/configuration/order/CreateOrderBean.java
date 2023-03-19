package com.pragma.foodcourt.infrastructure.configuration.order;

import com.pragma.foodcourt.domain.api.order.ICreateOrderServicePort;
import com.pragma.foodcourt.domain.spi.order.ICreateOrderPersistencePort;
import com.pragma.foodcourt.domain.usecase.order.CreateOrderUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.order.CreateOrderAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IDishOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateOrderBean {

    private final IOrderRepository orderRepository;
    private final IDishOrderRepository dishOrderRepository;
    private final IOrderEntityMapper orderEntityMapper;
    private final IDishOrderEntityMapper dishOrderEntityMapper;

    @Bean
    public ICreateOrderPersistencePort createOrderPersistencePort() {
        return new CreateOrderAdapter(orderRepository, dishOrderRepository,
                orderEntityMapper, dishOrderEntityMapper);
    }

    @Bean
    public ICreateOrderServicePort createOrderServicePort() {
        return new CreateOrderUseCase(createOrderPersistencePort());
    }

}

package com.pragma.foodcourt.infrastructure.configuration.order;

import com.pragma.foodcourt.domain.api.order.IReadOrderServicePort;
import com.pragma.foodcourt.domain.spi.order.IReadOrderPersistencePort;
import com.pragma.foodcourt.domain.usecase.order.ReadOrderUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.order.ReadOrderAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IReadOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReadOrderBean {

    private final IOrderRepository orderRepository;
    private final IDishOrderRepository dishOrderRepository;
    private final IReadOrderEntityMapper readOrderEntityMapper;

    @Bean
    public IReadOrderPersistencePort readOrderPersistencePort() {
        return new ReadOrderAdapter(orderRepository, dishOrderRepository, readOrderEntityMapper);
    }

    @Bean
    public IReadOrderServicePort readOrderServicePort() {
        return new ReadOrderUseCase(readOrderPersistencePort());
    }

}

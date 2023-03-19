package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IDishOrderRepository extends JpaRepository<DishOrderEntity, Long> {

    List<DishOrderEntity> findAllByOrderEntityStatusAndOrderEntityIdRestaurantId(String status, Long restaurantId);

}

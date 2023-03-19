package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByStatusAndIdRestaurant(String status, RestaurantEntity restaurantEntity);

}

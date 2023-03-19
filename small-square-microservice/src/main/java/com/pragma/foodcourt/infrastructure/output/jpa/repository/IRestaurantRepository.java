package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    @Query("SELECT r FROM RestaurantEntity r ORDER BY r.name ASC")
    List<RestaurantEntity> findAllOrderByNameAsc();
}

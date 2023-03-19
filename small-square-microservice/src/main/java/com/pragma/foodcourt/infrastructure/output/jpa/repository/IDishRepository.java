package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {

    List<DishEntity>  findDishByIdRestaurantOrderByIdCategory(RestaurantEntity id);

}

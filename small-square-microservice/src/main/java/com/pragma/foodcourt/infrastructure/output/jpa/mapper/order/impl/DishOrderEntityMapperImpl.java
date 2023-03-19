package com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.impl;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.model.RestaurantModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.CategoryEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishOrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.OrderEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IDishOrderEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class DishOrderEntityMapperImpl implements IDishOrderEntityMapper {


    @Override
    public DishOrderEntity toDishOrderEntity(DishOrderModel dishOrderModel) {
        if ( dishOrderModel == null ) {
            return null;
        }

        DishOrderEntity dishOrderEntity = new DishOrderEntity();

        dishOrderEntity.setId( dishOrderModel.getId() );
        dishOrderEntity.setOrderEntity( orderModelToOrderEntity(dishOrderModel.getOrderModel()) );
        dishOrderEntity.setDishEntity( dishModeltoDishEntity(dishOrderModel.getDishModel()) );
        dishOrderEntity.setAmount( dishOrderModel.getAmount() );

        return dishOrderEntity;
    }

    @Override
    public DishOrderModel toDishOrderModel(DishOrderEntity dishOrderEntity) {
        if ( dishOrderEntity == null ) {
            return null;
        }

        DishOrderModel dishOrderModel = new DishOrderModel();

        dishOrderModel.setId(dishOrderEntity.getId() );
        dishOrderModel.setOrderModel( orderEntityToOrderModel(dishOrderEntity.getOrderEntity()) );
        dishOrderModel.setDishModel( dishEntityToDishModel(dishOrderEntity.getDishEntity()) );

        return dishOrderModel;
    }

    protected OrderModel orderEntityToOrderModel(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setId( orderEntity.getId() );
        orderModel.setIdClient( orderEntity.getIdClient() );
        orderModel.setDate( orderEntity.getDate() );
        orderModel.setStatus( orderEntity.getStatus() );
        orderModel.setIdChef( orderEntity.getIdChef() );
        orderModel.setIdRestaurant( restaurantEntityToRestaurantModel( orderEntity.getIdRestaurant() ) );

        return orderModel;
    }

    protected OrderEntity orderModelToOrderEntity(OrderModel orderModel) {
        if ( orderModel == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( orderModel.getId() );
        orderEntity.setIdClient( orderModel.getIdClient() );
        orderEntity.setDate( orderModel.getDate() );
        orderEntity.setStatus( orderModel.getStatus() );
        orderEntity.setIdChef( orderModel.getIdChef() );
        orderEntity.setIdRestaurant( restaurantModelToRestaurantEntity( orderModel.getIdRestaurant() ) );

        return orderEntity;
    }

    protected DishModel dishEntityToDishModel(DishEntity dishEntity) {
        if ( dishEntity == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setId( dishEntity.getId() );
        dishModel.setName( dishEntity.getName() );
        dishModel.setPrice( dishEntity.getPrice() );
        dishModel.setDescription( dishEntity.getDescription() );
        dishModel.setUrlImage( dishEntity.getUrlImage() );
        dishModel.setActive( dishEntity.isActive() );
        dishModel.setIdRestaurant( restaurantEntityToRestaurantModel( dishEntity.getIdRestaurant() ) );
        dishModel.setIdCategory( categoryEntityToCategoryModel( dishEntity.getIdCategory() ) );

        return dishModel;
    }

    protected DishEntity dishModeltoDishEntity(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();

        dishEntity.setId( dishModel.getId() );
        dishEntity.setName( dishModel.getName() );
        dishEntity.setPrice( dishModel.getPrice() );
        dishEntity.setDescription( dishModel.getDescription() );
        dishEntity.setUrlImage( dishModel.getUrlImage() );
        dishEntity.setActive( dishModel.isActive() );
        dishEntity.setIdRestaurant( restaurantModelToRestaurantEntity( dishModel.getIdRestaurant() ) );
        dishEntity.setIdCategory( categoryModelToCategoryEntity( dishModel.getIdCategory() ) );

        return dishEntity;
    }

    protected RestaurantModel restaurantEntityToRestaurantModel(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId( restaurantEntity.getId() );
        restaurantModel.setName( restaurantEntity.getName() );
        restaurantModel.setNit( restaurantEntity.getNit() );
        restaurantModel.setAddress( restaurantEntity.getAddress() );
        restaurantModel.setPhone( restaurantEntity.getPhone() );
        restaurantModel.setUrlLogo( restaurantEntity.getUrlLogo() );
        restaurantModel.setIdOwner( restaurantEntity.getIdOwner() );

        return restaurantModel;
    }

    protected CategoryModel categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId( categoryEntity.getId() );
        categoryModel.setName( categoryEntity.getName() );
        categoryModel.setDescription( categoryEntity.getDescription() );

        return categoryModel;
    }

    protected RestaurantEntity restaurantModelToRestaurantEntity(RestaurantModel restaurantModel) {
        if ( restaurantModel == null ) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId( restaurantModel.getId() );
        restaurantEntity.setName( restaurantModel.getName() );
        restaurantEntity.setNit( restaurantModel.getNit() );
        restaurantEntity.setAddress( restaurantModel.getAddress() );
        restaurantEntity.setPhone( restaurantModel.getPhone() );
        restaurantEntity.setUrlLogo( restaurantModel.getUrlLogo() );
        restaurantEntity.setIdOwner( restaurantModel.getIdOwner() );

        return restaurantEntity;
    }

    protected CategoryEntity categoryModelToCategoryEntity(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryModel.getId() );
        categoryEntity.setName( categoryModel.getName() );
        categoryEntity.setDescription( categoryModel.getDescription() );

        return categoryEntity;
    }
}

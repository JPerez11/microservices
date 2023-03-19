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
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IReadOrderEntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ReadOrderEntityMapperImpl implements IReadOrderEntityMapper {


    @Override
    public List<OrderModel> toOrderModelList(List<OrderEntity> orderEntities) {
        if ( orderEntities == null ) {
            return Collections.emptyList();
        }

        List<OrderModel> list = new ArrayList<>( orderEntities.size() );
        for ( OrderEntity orderEntity : orderEntities ) {
            list.add( orderEntityToOrderModel( orderEntity ) );
        }

        return list;
    }

    @Override
    public List<DishOrderModel> toDishOrderModelList(List<DishOrderEntity> orderEntities) {
        if ( orderEntities == null ) {
            return Collections.emptyList();
        }

        List<DishOrderModel> list = new ArrayList<>( orderEntities.size() );
        for ( DishOrderEntity dishOrderEntity : orderEntities ) {
            list.add( dishOrderEntityToDishOrderModel( dishOrderEntity ) );
        }

        return list;
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


    protected DishOrderModel dishOrderEntityToDishOrderModel(DishOrderEntity dishOrderEntity) {
        if ( dishOrderEntity == null ) {
            return null;
        }

        DishOrderModel dishOrderModel = new DishOrderModel();

        dishOrderModel.setId( dishOrderEntity.getId() );
        dishOrderModel.setOrderModel( orderEntityToOrderModel(
                dishOrderEntity.getOrderEntity()) );
        dishOrderModel.setDishModel( dishEntityToDishModel(
                dishOrderEntity.getDishEntity()) );
        dishOrderModel.setAmount( dishOrderEntity.getAmount() );

        return dishOrderModel;
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

}

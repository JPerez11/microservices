package com.pragma.foodcourt.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DISH_ORDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishOrderEntity {

    @Id
    @Column(name = "id_dish_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "id_dish", nullable = false)
    private DishEntity dishEntity;
    @Column(nullable = false)
    private int amount;
}

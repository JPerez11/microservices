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
@Table(name = "DISH")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishEntity {

    @Id
    @Column(name = "id_dish", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String description;
    @Column(name = "url_image", nullable = false)
    private String urlImage;
    @Column(nullable = false)
    private boolean active = true;
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private RestaurantEntity idRestaurant;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private CategoryEntity idCategory;

}

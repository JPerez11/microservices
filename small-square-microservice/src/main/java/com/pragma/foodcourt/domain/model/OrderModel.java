package com.pragma.foodcourt.domain.model;

import java.time.LocalDateTime;

public class OrderModel {

    private Long id;
    private Long idClient;
    private LocalDateTime date;
    private String status;
    private Long idChef;
    private RestaurantModel idRestaurant;

    public OrderModel() {}

    public OrderModel(Long id, Long idClient, LocalDateTime date, String status, Long idChef, RestaurantModel idRestaurant) {
        this.id = id;
        this.idClient = idClient;
        this.date = date;
        this.status = status;
        this.idChef = idChef;
        this.idRestaurant = idRestaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

    public RestaurantModel getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(RestaurantModel idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}

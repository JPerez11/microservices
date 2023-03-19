package com.pragma.foodcourt.domain.model;

public class DishModel {

    private Long id;
    private String name;
    private int price;
    private String description;
    private String urlImage;
    private boolean active = true;
    private RestaurantModel idRestaurant;
    private CategoryModel idCategory;

    public DishModel(){}

    public DishModel(Long id, String name, int price, String description, String urlImage,
                     boolean active, RestaurantModel idRestaurant, CategoryModel idCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.urlImage = urlImage;
        this.active = active;
        this.idRestaurant = idRestaurant;
        this.idCategory = idCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RestaurantModel getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(RestaurantModel idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public CategoryModel getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(CategoryModel idCategory) {
        this.idCategory = idCategory;
    }
}

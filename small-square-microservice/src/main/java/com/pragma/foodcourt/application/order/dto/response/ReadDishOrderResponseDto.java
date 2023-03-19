package com.pragma.foodcourt.application.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadDishOrderResponseDto {

    private String dishName;
    private String description;
    private String urlImage;
    private int price;
    private boolean active;
    private int amount;

}

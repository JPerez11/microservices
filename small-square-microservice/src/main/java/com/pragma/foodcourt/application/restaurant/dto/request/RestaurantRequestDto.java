package com.pragma.foodcourt.application.restaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDto {

    private String name;
    private int nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long idOwner;

}

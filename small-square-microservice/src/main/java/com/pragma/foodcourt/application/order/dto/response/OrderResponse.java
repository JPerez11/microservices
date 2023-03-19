package com.pragma.foodcourt.application.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private ReadOrderResponseDto order;
    private ReadDishOrderResponseDto dishOrder;

}

package com.pragma.foodcourt.application.dish.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
public class UpdateDishRequestDto {

    @NotNull
    @NotEmpty(message = "Field id cannot empty")
    private Long id;
    @NotNull
    @NotEmpty(message = "Field price cannot empty")
    @Positive
    private int price;
    @NotNull
    @NotEmpty(message = "Field description cannot empty")
    private String description;

}

package com.pragma.foodcourt.application.dish.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateDishStatusRequestDto {

    @NotNull
    @NotEmpty(message = "Field id cannot empty")
    private Long id;
    @NotNull(message = "Field active cannot empty")
    @NotEmpty(message = "Field active cannot empty")
    private boolean active;

}

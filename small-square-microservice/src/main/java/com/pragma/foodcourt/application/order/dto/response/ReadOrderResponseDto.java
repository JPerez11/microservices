package com.pragma.foodcourt.application.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadOrderResponseDto {

    private Long idClient;
    private LocalDateTime date;
    private String status;

}

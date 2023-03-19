package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.restaurant.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.restaurant.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.application.restaurant.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/restaurant")
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant already exists",
                    content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurant(
            @RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All restaurants returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantHandler.getAllRestaurants());
    }
}

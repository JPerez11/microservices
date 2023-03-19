package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.dish.dto.request.SaveDishRequestDto;
import com.pragma.foodcourt.application.dish.dto.request.UpdateDishRequestDto;
import com.pragma.foodcourt.application.dish.dto.request.UpdateDishStatusRequestDto;
import com.pragma.foodcourt.application.dish.dto.response.ReadDishResponseDto;
import com.pragma.foodcourt.application.dish.handler.IReadDishHandler;
import com.pragma.foodcourt.application.dish.handler.ICreateDishHandler;
import com.pragma.foodcourt.application.dish.handler.IUpdateDishHandler;
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
@RequestMapping("/api/food-court/dish")
public class DishRestController {

    private final ICreateDishHandler saveDishHandler;
    private final IReadDishHandler readDishHandler;
    private final IUpdateDishHandler updateDishHandler;

    @Operation(summary = "Add a new dish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dish created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Dish already exists",
                    content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveDish(@RequestBody SaveDishRequestDto saveDishRequestDto) {
        saveDishHandler.saveDish(saveDishRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all dish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All dish returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = ReadDishResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<ReadDishResponseDto>> getDishes() {
        return ResponseEntity.ok(readDishHandler.findAllDish());
    }

    @Operation(summary = "Get all dish from your restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All dish returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = ReadDishResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<List<ReadDishResponseDto>> readDish(@PathVariable Long id) {
        //For the time it's like this, it's time to change to make it more dynamic
        return ResponseEntity.ok(readDishHandler.findDishByIdRestaurantOrderByIdCategory(id));
    }

    @Operation(summary = "Update a dish")
    @PutMapping("/update")
    public ResponseEntity<Void> updateDish(@RequestBody UpdateDishRequestDto updateDishRequest) {
        updateDishHandler.updateDish(updateDishRequest);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Update a dish status")
    @PutMapping("/status")
    public ResponseEntity<Void> updateDishStatus(@RequestBody UpdateDishStatusRequestDto updateDishStatusRequest) {
        updateDishHandler.updateDishStatus(updateDishStatusRequest);
        return ResponseEntity.noContent().build();
    }
}

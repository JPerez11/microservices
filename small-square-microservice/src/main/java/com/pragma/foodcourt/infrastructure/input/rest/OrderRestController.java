package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.order.dto.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.request.CreateOrderRequestDto;
import com.pragma.foodcourt.application.order.dto.response.OrderResponse;
import com.pragma.foodcourt.application.order.handler.ICreateOrderHandler;
import com.pragma.foodcourt.application.order.handler.IReadOrderHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/orders")
public class OrderRestController {

    private final IReadOrderHandler readOrderHandler;
    private final ICreateOrderHandler createOrderHandler;

    @Operation(summary = "Add a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "order created", content = @Content),
            @ApiResponse(responseCode = "409", description = "order already exists",
                    content = @Content)
    })
    @PostMapping("/order")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        createOrderHandler.createOrder(createOrderRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Add a new dish order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "dish order created", content = @Content),
            @ApiResponse(responseCode = "409", description = "dish order already exists",
                    content = @Content)
    })
    @PostMapping("/dish-order")
    public ResponseEntity<Void> createDishOrder(@RequestBody CreateDishOrderRequestDto createDishOrderRequestDto) {
        createOrderHandler.createDishOrder(createDishOrderRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get order by restaurant and status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get order by restaurant",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = OrderResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public List<OrderResponse> getOrders(@RequestParam String status, @RequestParam Long idRestaurant) {
        return readOrderHandler.getOrder(status, idRestaurant);
    }

    @Operation(summary = "Get order for restaurant id and status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get paginated order by restaurant",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = OrderResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/paginated")
    public Page<OrderResponse> getOrdersPaginated(@RequestParam String status, @RequestParam Long idRestaurant,
                                                  @RequestParam int pageNumber, @RequestParam int pageSize) {

        List<OrderResponse> orderResponseList = readOrderHandler.getOrder(status, idRestaurant);
        int orderSize = orderResponseList.size();
        int start = pageNumber * pageSize;
        int end = Math.min(start + pageSize, orderSize);

        List<OrderResponse> orderResponsePage = orderResponseList.subList(start, end);

        return new PageImpl<>(orderResponsePage, PageRequest.of(pageNumber, pageSize), orderSize);
    }


}

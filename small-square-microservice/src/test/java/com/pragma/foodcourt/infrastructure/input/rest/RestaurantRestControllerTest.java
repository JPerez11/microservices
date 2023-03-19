package com.pragma.foodcourt.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.foodcourt.application.restaurant.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.restaurant.handler.IRestaurantHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class RestaurantRestControllerTest {

    @InjectMocks
    private RestaurantRestController restaurantRestController;
    @Mock
    private IRestaurantHandler restaurantHandler;
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantRestController).build();
    }

    @Test
    void saveRestaurant() throws Exception {
        //Given
        RestaurantRequestDto restaurantRequestDto = new RestaurantRequestDto();
        restaurantRequestDto.setName("Restaurant");
        restaurantRequestDto.setIdOwner(1L);
        restaurantRequestDto.setNit(1234567890);
        restaurantRequestDto.setAddress("street");
        restaurantRequestDto.setPhone("1234567890");
        restaurantRequestDto.setUrlLogo("url");

        //When
        Mockito.doNothing().when(restaurantHandler).saveRestaurant(restaurantRequestDto);
//        MockHttpServletRequestBuilder request = get("/api/food-court/restaurant/");
        MockHttpServletRequestBuilder request = post("/api/food-court/restaurant/");
        mockMvc.perform(request
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(restaurantRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
        //Then
        Mockito.verify(restaurantHandler, Mockito.times(1)).saveRestaurant(restaurantRequestDto);

    }

    private String jsonToString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllRestaurants() {
    }
}
package com.pragma.foodcourt.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.foodcourt.application.user.dto.request.UserRequestDto;
import com.pragma.foodcourt.application.user.dto.response.UserResponseDto;
import com.pragma.foodcourt.application.user.handler.IUserHandler;
import com.pragma.foodcourt.domain.model.RoleModel;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {

    @InjectMocks
    UserRestController userRestController;

    @Mock
    IUserHandler userHandler;
    @Mock
    IRoleRepository roleRepository;
    @Mock
    IRoleEntityMapper roleEntityMapper;
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userRestController).build();
    }

    @Test
    void saveUser() throws Exception {
        //Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("User");
        userRequestDto.setLastName("User");
        userRequestDto.setDocument(1234567890);
        userRequestDto.setPhone("1234567890");
        userRequestDto.setEmail("user@gmail.com");
        userRequestDto.setPassword("password");

        //When
        Mockito.doNothing().when(userHandler).saveUser(userRequestDto);
        mockMvc.perform(
                post("/api/food-court/users/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(userRequestDto)))
                .andExpect(status().isCreated());

        //Then
        Mockito.verify(userHandler).saveUser(userRequestDto);
    }

    @Test
    void getAllUsers() throws Exception {
        //Given
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        UserResponseDto user1 = new UserResponseDto();
        user1.setName("User");
        user1.setLastName("User");
        user1.setDocument(123456789);
        user1.setPhone("+1234567890");
        user1.setEmail("user@test.com");

        userResponseDtoList.add(user1);

        //When
        Mockito.when(userHandler.getAllUsers()).thenReturn(userResponseDtoList);
        mockMvc.perform(get("/api/food-court/users/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("User")))
                .andExpect(jsonPath("$[0].lastName", is("User")))
                .andExpect(jsonPath("$[0].document", is(123456789)))
                .andExpect(jsonPath("$[0].phone", is("+1234567890")))
                .andExpect(jsonPath("$[0].email", is("user1@test.com")));

        //Then
        Mockito.verify(userHandler).getAllUsers();

    }

    public static String jsonToString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
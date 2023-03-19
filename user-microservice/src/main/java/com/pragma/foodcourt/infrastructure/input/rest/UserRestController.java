package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.user.dto.request.UserRequestDto;
import com.pragma.foodcourt.application.user.dto.response.UserResponseDto;
import com.pragma.foodcourt.application.user.handler.IUserHandler;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import com.pragma.foodcourt.infrastructure.action.Actions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/users")
public class UserRestController {

    private final IUserHandler userHandler;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Operation(summary = "Add a new users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content)
    })
    @PostMapping("/")
    @Secured({"ADMIN", "OWNER"})
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto) {
        RoleEntity rol = Actions.getRoleWithAuthentication(roleRepository);
        userRequestDto.setIdRole(roleEntityMapper.toRoleModel(rol));
        userHandler.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(
                                    implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    @Secured({"ADMIN", "OWNER"})
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userHandler.getAllUsers());
    }

}
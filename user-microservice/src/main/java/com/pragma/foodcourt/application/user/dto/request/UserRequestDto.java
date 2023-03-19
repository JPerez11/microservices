package com.pragma.foodcourt.application.user.dto.request;

import com.pragma.foodcourt.domain.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotNull(message = "The field name cannot null")
    @NotEmpty(message = "The field name cannot empty")
    private String name;

    @NotNull(message = "The field last name cannot null")
    @NotEmpty(message = "The field last name cannot empty")
    private String lastName;

    @NotNull(message = "The field document cannot null")
    @NotEmpty(message = "The field document cannot empty")
    private int document;

    @NotNull(message = "The field phone cannot null")
    @NotEmpty(message = "The field phone cannot empty")
    private String phone;

    @Email(message = "The email format is invalid")
    @NotNull(message = "The field email cannot null")
    @NotEmpty(message = "The field email cannot empty")
    private String email;

    @NotNull(message = "The field password cannot null")
    @NotEmpty(message = "The field password cannot empty")
    private String password;

    private RoleModel idRole;

}

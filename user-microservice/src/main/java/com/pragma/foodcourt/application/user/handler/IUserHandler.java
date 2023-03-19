package com.pragma.foodcourt.application.user.handler;

import com.pragma.foodcourt.application.user.dto.request.UserRequestDto;
import com.pragma.foodcourt.application.user.dto.response.UserResponseDto;
import com.pragma.foodcourt.application.user.dto.request.login.LoginRegister;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

    void registerUser(LoginRegister loginRegister);

    List<UserResponseDto> getAllUsers();

}

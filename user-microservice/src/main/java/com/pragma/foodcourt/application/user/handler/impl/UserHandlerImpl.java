package com.pragma.foodcourt.application.user.handler.impl;

import com.pragma.foodcourt.application.user.dto.request.UserRequestDto;
import com.pragma.foodcourt.application.user.dto.response.UserResponseDto;
import com.pragma.foodcourt.application.user.handler.IUserHandler;
import com.pragma.foodcourt.application.user.mapper.IUserRequestMapper;
import com.pragma.foodcourt.application.user.mapper.IUserResponseMapper;
import com.pragma.foodcourt.domain.api.IUserServicePort;
import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.domain.util.IUserPasswordEncrypt;
import com.pragma.foodcourt.application.user.dto.request.login.LoginRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;
    private final IUserPasswordEncrypt passwordEncrypt;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncrypt.passwordEncoder(userRequestDto.getPassword()));
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
    }

    @Override
    public void registerUser(LoginRegister loginRegister) {
        loginRegister.setPassword(passwordEncrypt.passwordEncoder(loginRegister.getPassword()));

        UserModel userModel = new UserModel();

        userModel.setName(loginRegister.getName() );
        userModel.setLastName(loginRegister.getLastName() );
        userModel.setEmail(loginRegister.getEmail() );
        userModel.setDocument(loginRegister.getDocument() );
        userModel.setPhone(loginRegister.getPhone() );
        userModel.setPassword(loginRegister.getPassword() );

        userServicePort.registerUser(userModel);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }
}

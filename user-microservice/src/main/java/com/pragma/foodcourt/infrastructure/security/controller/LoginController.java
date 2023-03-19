package com.pragma.foodcourt.infrastructure.security.controller;

import com.pragma.foodcourt.application.user.dto.request.login.LoginRegister;
import com.pragma.foodcourt.application.user.handler.IUserHandler;
import com.pragma.foodcourt.infrastructure.security.dto.AuthCredentials;
import com.pragma.foodcourt.infrastructure.security.dto.LoginResponse;
import com.pragma.foodcourt.infrastructure.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final IUserHandler userHandler;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthCredentials authCredentials) {
        return LoginResponse.builder()
                .token(loginService.login(authCredentials))
                .build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> loginResponse(@RequestBody LoginRegister loginRegister) {
        userHandler.registerUser(loginRegister);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

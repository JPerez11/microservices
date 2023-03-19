package com.pragma.foodcourt.infrastructure.impl;

import com.pragma.foodcourt.domain.util.IUserPasswordEncrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserPasswordEncryptImpl implements IUserPasswordEncrypt {

    private final PasswordEncoder encryptor;

    @Override
    public String passwordEncoder(String password) {
        return encryptor.encode(password);
    }

}

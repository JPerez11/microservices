package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.UserModel;

import java.util.List;

public interface IUserServicePort {

    void saveUser(UserModel userModel);

    void registerUser(UserModel userModel);

    List<UserModel> getAllUsers();

}

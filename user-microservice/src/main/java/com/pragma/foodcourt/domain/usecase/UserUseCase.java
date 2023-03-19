package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.domain.api.IUserServicePort;
import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import com.pragma.foodcourt.domain.validation.Validations;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        Validations validations = new Validations();
        userPersistencePort.saveUser(validations.validationsModel(userModel));
    }

    @Override
    public void registerUser(UserModel userModel) {
        Validations validations = new Validations();
        userPersistencePort.registerUser(validations.validationsModel(userModel));
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }
}

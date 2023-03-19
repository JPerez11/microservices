package com.pragma.foodcourt.infrastructure.output.jpa.adapter;

import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.UserEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public UserModel saveUser(UserModel userModel) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toUserEntity(userModel));
        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public UserModel registerUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(userModel.getName() );
        userEntity.setLastName(userModel.getLastName() );
        userEntity.setEmail(userModel.getEmail() );
        userEntity.setDocument(userModel.getDocument() );
        userEntity.setPhone(userModel.getPhone() );
        userEntity.setPassword(userModel.getPassword() );
        userEntity.setIdRole( roleRepository.findByName("CUSTOMER") );

        userRepository.save(userEntity);

        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if(userEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserModelList(userEntityList);
    }
}

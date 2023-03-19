package com.pragma.foodcourt.infrastructure.output.jpa.mapper;

import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserEntity toUserEntity(UserModel userModel);

    UserModel toUserModel(UserEntity userEntity);

    List<UserModel> toUserModelList(List<UserEntity> userEntityList);


}

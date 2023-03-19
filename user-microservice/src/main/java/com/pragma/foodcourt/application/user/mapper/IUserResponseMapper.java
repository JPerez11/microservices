package com.pragma.foodcourt.application.user.mapper;


import com.pragma.foodcourt.application.user.dto.response.UserResponseDto;
import com.pragma.foodcourt.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponse(UserModel userModel);

    List<UserResponseDto> toResponseList(List<UserModel> userModelList);

}

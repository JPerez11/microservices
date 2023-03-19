package com.pragma.foodcourt.application.user.mapper;

import com.pragma.foodcourt.application.user.dto.request.UserRequestDto;
import com.pragma.foodcourt.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    UserModel toUser(UserRequestDto userRequestDto);

}

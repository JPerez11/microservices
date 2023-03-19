package com.pragma.foodcourt.application.role.mapper;


import com.pragma.foodcourt.application.role.dto.response.RoleResponseDto;
import com.pragma.foodcourt.domain.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {

    RoleResponseDto toResponse(RoleModel roleModel);

    List<RoleResponseDto> toResponseList(List<RoleModel> roleModelList);

}

package com.pragma.foodcourt.application.role.mapper;


import com.pragma.foodcourt.application.role.dto.request.RoleRequestDto;
import com.pragma.foodcourt.domain.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {

    RoleModel toRole(RoleRequestDto roleRequestDto);

}

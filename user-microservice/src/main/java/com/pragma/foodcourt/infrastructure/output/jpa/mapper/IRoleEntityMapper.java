package com.pragma.foodcourt.infrastructure.output.jpa.mapper;

import com.pragma.foodcourt.domain.model.RoleModel;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {

    RoleModel toRoleModel(RoleEntity roleEntity);
}

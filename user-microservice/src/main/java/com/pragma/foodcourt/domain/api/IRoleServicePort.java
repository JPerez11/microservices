package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.RoleModel;

import java.util.List;

public interface IRoleServicePort {

    List<RoleModel> getAllRoles();

}

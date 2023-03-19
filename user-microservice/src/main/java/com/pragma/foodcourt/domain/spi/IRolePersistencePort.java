package com.pragma.foodcourt.domain.spi;

import com.pragma.foodcourt.domain.model.RoleModel;

import java.util.List;

public interface IRolePersistencePort {

    List<RoleModel> getAllRoles();

}

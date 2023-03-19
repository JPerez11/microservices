package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);

}

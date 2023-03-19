package com.pragma.foodcourt.infrastructure.output.jpa.repository;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    Optional<UserEntity> findOneByEmail(String email);

}

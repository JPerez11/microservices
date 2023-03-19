package com.pragma.foodcourt.infrastructure.action;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class Actions {

    private Actions() {}

    public static RoleEntity getRoleWithAuthentication(IRoleRepository roleRepository) {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElseThrow( () -> new UsernameNotFoundException("No exist rol on database."));
        for (RoleEntity rol :
                roleEntities) {
            if (rol.getName().equalsIgnoreCase(role)) {
                return roleRepository.findById(rol.getId() + 1)
                        .orElseThrow(() -> new UsernameNotFoundException("No exist rol on database."));
            } else if (rol.getName().equalsIgnoreCase("CUSTOMER")) {
                return null;
            }
        }
        return null;

    }
}

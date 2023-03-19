package com.pragma.foodcourt.infrastructure.output.jpa.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String name;
    @Column(name ="last_name", length = 50, nullable = false)
    private String lastName;
    @Column(length = 20, nullable = false, unique = true)
    private int document;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 13, nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private RoleEntity idRole;


}

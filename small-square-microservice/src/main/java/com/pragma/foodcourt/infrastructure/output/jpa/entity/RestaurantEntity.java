package com.pragma.foodcourt.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {

    @Id
    @Column(name = "id_restaurant", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private int nit;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 13)
    private String phone;
    @Column(name = "url_logo", nullable = false)
    private String urlLogo;
    @Column(name = "id_owner", nullable = false)
    private Long idOwner;

}

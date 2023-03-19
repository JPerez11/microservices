package com.pragma.foodcourt.domain.model;

import com.pragma.foodcourt.domain.validation.Validations;

public class UserModel {

    private Long id;

    private String name;

    private String lastName;

    private int document;

    private String phone;

    private String email;

    private String password;

    private RoleModel idRole;

    public UserModel() {
    }

    public UserModel(Long id, String name, String lastName, int document, String phone, String email,
                     String password, RoleModel idRol) {
        Validations valid = new Validations();
        this.id = id;
        this.name = valid.emptyStringValidate(name);
        this.lastName = valid.emptyStringValidate(lastName);
        this.document = document;
        this.phone = valid.numberPhoneValidate(valid.emptyStringValidate(phone));
        this.email = valid.emailValidate(valid.emptyStringValidate(email));
        this.password = valid.emptyStringValidate(password);
        this.idRole = idRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getIdRole() {
        return idRole;
    }

    public void setIdRole(RoleModel idRole) {
        this.idRole = idRole;
    }


}

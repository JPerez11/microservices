package com.pragma.foodcourt.domain.validation;

import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.UserModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    private static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String REGEX_PHONE = "^\\+?\\d+$";

    public UserModel validationsModel(UserModel userModel) {
        userModel.setName(emptyStringValidate(userModel.getName()));
        userModel.setLastName(emptyStringValidate(userModel.getLastName()));
        userModel.setEmail(emailValidate(emptyStringValidate(userModel.getEmail())));
        userModel.setPhone(numberPhoneValidate(userModel.getPhone()));

        return userModel;
    }

    public String emptyStringValidate(String data) {
        if(data.isEmpty()) {
            throw new DomainException("The field cannot empty");
        }
        return data;
    }

    public String emailValidate(String email) {
        Pattern pattern = Pattern
                .compile(REGEX_EMAIL);
        Matcher mather = pattern.matcher(email);

        if(!mather.find()) {
            throw new DomainException("The mail format is invalid");
        }
        return email;
    }

    public String numberPhoneValidate(String phone) {
        Pattern pattern = Pattern
                .compile(REGEX_PHONE);
        Matcher mather = pattern.matcher(phone);
        if(!mather.find()) {
            throw new DomainException("The phone format is invalid");
        }
        if(phone.length() > 13) {
            throw new DomainException("The content of the phone must contain a maximum of 13 characters");
        }
        return phone;
    }

}

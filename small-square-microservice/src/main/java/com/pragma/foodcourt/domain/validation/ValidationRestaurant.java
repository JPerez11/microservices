package com.pragma.foodcourt.domain.validation;

import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.RestaurantModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRestaurant {
    private static final String VALID_PHONE = "^\\+?\\d+$";

    public RestaurantModel validationsModel(RestaurantModel restaurantModel) {
        restaurantModel.setName( emptyValidate(restaurantModel.getName()) );
        restaurantModel.setAddress( emptyValidate(restaurantModel.getAddress()) );
        restaurantModel.setNit( emptyValidate(restaurantModel.getNit()) );
        restaurantModel.setUrlLogo( emptyValidate(restaurantModel.getUrlLogo()) );
        restaurantModel.setPhone( numberPhoneValidate(
                emptyValidate(restaurantModel.getPhone()) ) );
        return restaurantModel;
    }

    public String emptyValidate(String data) {
        if(data.isEmpty()) {
            throw new DomainException("The field cannot empty");
        }
        return data;
    }

    public int emptyValidate(int data) {
        if(data == 0) {
            throw new DomainException("The field cannot empty");
        }
        return data;
    }

    public String numberPhoneValidate(String phone) {
        Pattern pattern = Pattern
                .compile(VALID_PHONE);
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

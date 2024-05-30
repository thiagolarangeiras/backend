package com.example.demo.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class CustomNotEmptyValidator implements ConstraintValidator<CustomNotEmpty, Object> {
    @Override
    public void initialize(CustomNotEmpty constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value instanceof String){
            String string = (String) value;
            return !string.trim().isEmpty();
        }
        if(value instanceof List<?>) {
            return !((List<?>) value).isEmpty();
        }
        return true;
    }
}


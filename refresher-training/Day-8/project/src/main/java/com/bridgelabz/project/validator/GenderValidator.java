package com.bridgelabz.project.validator;

import com.bridgelabz.project.annotation.ValidGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {

        if (gender == null) {
            return true;
        }

        return gender.equalsIgnoreCase("Male")
                || gender.equalsIgnoreCase("Female");
    }
}
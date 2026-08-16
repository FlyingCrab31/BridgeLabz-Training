package com.bridgelabz.project.annotation;

import com.bridgelabz.project.validator.GenderValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderValidator.Class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGender {
    String message() default "Gender must be male or female";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}

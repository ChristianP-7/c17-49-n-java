package com.medilatam.backend.Security;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "La contraseña debe tener al menos 6 caracteres, una mayúscula y un número";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.pokedex.pokedex.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueEvolutionCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEvolutionCode {
    String message() default "El código de la evolución ya existe en la base de datos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

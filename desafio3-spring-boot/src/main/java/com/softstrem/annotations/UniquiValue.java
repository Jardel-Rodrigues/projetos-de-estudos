package com.softstrem.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)

public @interface UniquiValue {
	String message() default "O valor já existe na base de dados";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}


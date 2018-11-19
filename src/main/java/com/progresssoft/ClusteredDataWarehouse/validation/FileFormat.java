package com.progresssoft.ClusteredDataWarehouse.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.progresssoft.ClusteredDataWarehouse.validator.FileFormatValidator;

@Constraint(validatedBy = FileFormatValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileFormat {

	String message() default "File must be csv.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

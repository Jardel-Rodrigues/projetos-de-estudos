package com.softstrem.annotations;

import org.springframework.beans.factory.annotation.Autowired;

import com.softstrem.repositores.ClientRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniquiValue, String> {

	@Autowired
	private ClientRepository repository;

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !repository.existsByCpf(value);
	}

}

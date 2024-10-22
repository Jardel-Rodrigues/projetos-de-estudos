package com.softstrem.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomExcetion {

	List<FieldMessege> errors = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String messege, String path) {
		super(timestamp, status, messege, path);

	}

	public List<FieldMessege> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messege) {
		errors.add(new FieldMessege(fieldName, messege));
	}

}

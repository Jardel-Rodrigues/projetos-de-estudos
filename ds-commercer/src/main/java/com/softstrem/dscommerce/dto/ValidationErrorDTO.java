package com.softstrem.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends CustomErrorDTO {

	private List<FieldMessegeDTO> errors = new ArrayList<>();

	public ValidationErrorDTO(Instant timestamp, Integer status, String message, String path) {
		super(timestamp, status, message, path);

	}

	public List<FieldMessegeDTO> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messege) {
		errors.removeIf(x -> x.getFieldName().equals(fieldName));
		errors.add(new FieldMessegeDTO(fieldName, messege));
	}

}

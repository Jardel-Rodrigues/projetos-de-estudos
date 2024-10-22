package com.softstrem.dscommerce.dto;

public class FieldMessegeDTO {

	private String fieldName;
	private String messege;

	public FieldMessegeDTO(String fieldName, String messege) {
		super();
		this.fieldName = fieldName;
		this.messege = messege;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessege() {
		return messege;
	}

}

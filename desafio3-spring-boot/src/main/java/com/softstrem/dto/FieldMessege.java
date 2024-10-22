package com.softstrem.dto;

public class FieldMessege {

	private String fieldName;
	private String messege;

	public FieldMessege(String fieldName, String messege) {
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

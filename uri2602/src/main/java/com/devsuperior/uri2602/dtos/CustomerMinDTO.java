package com.devsuperior.uri2602.dtos;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO {

	private String name;

	public CustomerMinDTO() {

	}

	public CustomerMinDTO(String name) {
		super();
		this.name = name;
	}

	public CustomerMinDTO(CustomerMinProjection projection) {
		name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerMinDTO [name=" + name + "]";
	}

}

package com.devsuperior.uri2609.dto;

import com.devsuperior.uri2609.projections.CategorySumProjection;

public class CategorySumDTO {

	private String name;
	private Double total;
	
	public CategorySumDTO() {
	}

	public CategorySumDTO(String name, Double total) {
		this.name = name;
		this.total = total;
	}

	public CategorySumDTO(CategorySumProjection projection) {
		name = projection.getName();
		total = projection.getSum();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CategorytotalDTO [name=" + name + ", sum=" + total + "]";
	}
}

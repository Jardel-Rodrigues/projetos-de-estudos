package com.devsuperior.dsmeta.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.devsuperior.dsmeta.projections.SaleMaxProjection;

public class SaleMaxDTO {

	private Long id;
	private LocalDate date;
	private BigDecimal amount;
	private String sellerName;

	public SaleMaxDTO(Long id, LocalDate date, BigDecimal amount, String sellerName) {

		this.id = id;
		this.date = date;
		this.amount = amount;
		this.sellerName = sellerName;
	}

	public SaleMaxDTO(SaleMaxProjection projection) {

		id = projection.getId();
		date = projection.getDate();
		amount = projection.getSum();
		sellerName = projection.getName();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getSellerName() {
		return sellerName;
	}

}

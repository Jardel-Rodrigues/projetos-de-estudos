package com.devsuperior.dsmeta.dtos;

import java.math.BigDecimal;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SaleSumDTO {

	private String sellerName;
	private BigDecimal total;

	public SaleSumDTO(String sellerName, BigDecimal total) {
		this.sellerName = sellerName;
		this.total = total;
	}
	
	public SaleSumDTO(Sale SaleEntity, Seller SellerEntity) {
		sellerName = SellerEntity.getName();
		total = SaleEntity.getAmount();
	}

	public String getSellerName() {
		return sellerName;
	}

	public BigDecimal getTotal() {
		return total;
	}

}

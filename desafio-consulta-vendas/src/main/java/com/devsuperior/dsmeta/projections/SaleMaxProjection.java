package com.devsuperior.dsmeta.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SaleMaxProjection {
	
	Long getId();
	LocalDate getDate();
	BigDecimal getSum();
	String getName();

}

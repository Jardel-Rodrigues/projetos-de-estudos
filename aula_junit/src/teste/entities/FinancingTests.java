package teste.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import teste.factory.FinancingFactory;

public class FinancingTests {
	
	
	@Test
	public void constructorShouldCreateObjectWhenValidData() {
		
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		Assertions.assertEquals(100000.00, finanacing.getTotalAmount());
		Assertions.assertEquals(2000.00, finanacing.getIncome());
		Assertions.assertEquals(80, finanacing.getMonths());
	}
	
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionObjectWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			@SuppressWarnings("unused")
			Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 20);

		});
		
	}
	
	@Test
	public void setTotalAmountShouldSetDataWhenValidData() {
		
		// arrange
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		// action
		finanacing.setTotalAmount(90000.00);
		
		// assert
		Assertions.assertEquals(90000.00, finanacing.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionObjectWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
			finanacing.setTotalAmount(110000.00);
		});
		
	}

	@Test
	public void setIncomeShouldSetDataWhenValidData() {
		
		// arrange
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		// action
		finanacing.setIncome(2100.00);
		
		// assert
		Assertions.assertEquals(2100.00, finanacing.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionObjectWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
			finanacing.setIncome(1900.00);
		});
		
	}
	
	@Test
	public void setMonthsShouldSetDataWhenValidData() {
		
		// arrange
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		// action
		finanacing.setMonths(81);
		
		// assert
		Assertions.assertEquals(81, finanacing.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionObjectWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
			finanacing.setMonths(79);
		});
		
	}
	
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		Assertions.assertEquals(20000.00, finanacing.entry());
		
	}

	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		
		Financing  finanacing = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		
		Assertions.assertEquals(1000.00, finanacing.quota());
		
	}
}

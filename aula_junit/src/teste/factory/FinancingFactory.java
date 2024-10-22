package teste.factory;

import entities.Financing;

public class FinancingFactory {
	
	public static Financing createFinancing(Double totalAmount, Double income, Integer months)  {
		return new Financing(totalAmount, income, months);
		
	}

}

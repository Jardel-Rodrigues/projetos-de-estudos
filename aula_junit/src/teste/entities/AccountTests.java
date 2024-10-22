package teste.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import teste.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositStouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		double amount = 200.00;
		double expectedValue = 196.00;
		
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothinWhenNegativeAmount() {
		
		double expectedValue = 100.00;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValeu = 0.0;
		double initialBalance = 800.00;
		
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullwithdraw(null);
		
		Assertions.assertTrue(expectedValeu == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.00);
		
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300.00, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShoulThrowExcetionWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.00);
			
			acc.withdraw(800.50);
		});
		
	}
	
}

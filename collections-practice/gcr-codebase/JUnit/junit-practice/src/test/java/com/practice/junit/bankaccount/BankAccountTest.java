package com.practice.junit.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
	
	private BankAccount account;
		
		@BeforeEach
		
		void setUp() {
			account=new BankAccount(1000);
		}
		
	@Test
		
		void testDeposit() {
			account.deposit(500);
			assertEquals(1500,account.getBalance());
		}
		
		
		@Test
		
		void testWithdraw() {
			account.withdraw(300);
			assertEquals(700,account.getBalance());
		}
		
//		@Test
//		
//		void testWithdrawlInsufficientFunds() {
//			Exception exception=assertThrows(IllegalStateException.class,()->{
//				account.withdraw(2000.0);
//			});
//			
//			assertEquals("Insufficient funds", exception.getMessage());
//		}
		
		@Test
		
		void testInvalidDeposit() {
			  IllegalArgumentException ex=	assertThrows(IllegalArgumentException.class,()->{
				account.deposit(-100);
			});
			assertEquals("Deposit amount must be greater than 0", ex.getMessage());
		}
		
		
@Test
		
		void testInvalidWithdraw() {
	IllegalArgumentException ex =	assertThrows(IllegalArgumentException.class,()->{
				account.withdraw(-10);
			});
	assertEquals("Withdrawl amount must be greater than 0", ex.getMessage());

		}
		
		
		
		
		
}
	



package com.bank.BankAccountJunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTest {

	//test deposit with valid amount
	@Test
	public void Test_Deposit_ValidAmount() {
		BankAccount account = new BankAccount(1000);
		account.deposit(500);
		assertEquals(1500, account.getBalance());
	}

	//test deposit with negative amount
	@Test
	public void Test_Deposit_NegativeAmount() {
		BankAccount account = new BankAccount(1000);
		Exception e = assertThrows(IllegalArgumentException.class, () -> account.deposit(-200));
		assertEquals("Deposit amount cannot be negative", e.getMessage());
	}

	//test withdraw with valid amount
	@Test
	public void Test_Withdraw_ValidAmount() {
		BankAccount account = new BankAccount(1000);
		account.withdraw(400);
		assertEquals(600, account.getBalance());
	}

	//test withdraw with insufficient funds
	@Test
	public void Test_Withdraw_InsufficientFunds() {
		BankAccount account = new BankAccount(500);
		Exception e = assertThrows(IllegalArgumentException.class, () -> account.withdraw(800));
		assertEquals("Insufficient funds.", e.getMessage());
	}
}
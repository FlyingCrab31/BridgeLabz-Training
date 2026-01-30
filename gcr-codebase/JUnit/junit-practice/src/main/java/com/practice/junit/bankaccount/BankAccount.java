package com.practice.junit.bankaccount;

public class BankAccount {
	
	private double balance;
	
	public BankAccount(double initial) {
		this.balance=initial;
	}
	
	
	public void deposit(double amount) {
		if(amount<=0) {
			throw new IllegalArgumentException("Deposit amount must be greater than 0");
		}
		
		balance=balance+amount;
		
	}
	
	public void withdraw(double amount) {
		if(amount<=0) throw new IllegalArgumentException("Withdrawl amount must be greater than 0");
		if(amount>balance) throw new IllegalStateException("Insufficient Balance");
		balance=balance-amount;
	}
	
	public double getBalance() {
		return balance;
	}

}

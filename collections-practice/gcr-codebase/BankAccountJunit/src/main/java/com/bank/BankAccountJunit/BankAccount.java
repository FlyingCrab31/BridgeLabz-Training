package com.bank.BankAccountJunit;

public class BankAccount {
    private double balance;

    //constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //method to deposit money
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    //method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    //getter method
    public double getBalance() {
        return balance;
    }
}
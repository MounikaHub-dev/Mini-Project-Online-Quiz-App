package com.task5;

import java.util.ArrayList;
import java.util.List;

public class Account {
	protected String accountHolder;
	protected double balance;
	protected List<String> transactionHistroy;

	public Account(String AccountHolder, double initialBalance) {
		this.accountHolder = accountHolder;
		this.balance = initialBalance;
		this.transactionHistroy = new ArrayList<>();
		transactionHistroy.add("Account Created with balence :" + initialBalance);

	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactionHistroy.add("Deposited :" + amount);
			System.out.println("Deposite sucessful. New Balencce :" + balance);

		} else {
			System.out.println("Invalid Deposite amount!!!");
		}

	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactionHistroy.add("WithDraw :" + amount);
			System.out.println("WithDraw Sucessful . New Balence :" + balance);

		} else {
			System.out.println("InValid WithDrawl amount or Insufficient Balence!!");
		}

	}

	public void showBalance() {
		System.out.println("Current Balence :" + balance);
	}

	public void showTransactionHistroy() {
		System.out.println("Transaction Histroy :");
		for (String transaction : transactionHistroy) {
			System.out.println(transaction);

		}
	}
}

class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
		super(accountHolder, initialBalance);
		this.interestRate = interestRate;
	}

	public void applyIntrest() {
		double interest = balance * interestRate / 100;
		balance += interest;
		transactionHistroy.add("Intrest added :" + interest);
		   System.out.println("Interest applied. New balance: " + balance);

	}

}

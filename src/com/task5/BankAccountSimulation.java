package com.task5;

import java.util.Scanner;

public class BankAccountSimulation {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Account Holder name :");
	String name = sc.nextLine();
	System.out.println("enter Intial Balance :");
	double initialBalance = sc.nextDouble();
	System.out.println("Enter Intrest rate : ");
	double intrestRate = sc.nextDouble();
	
	SavingsAccount account = new SavingsAccount(name,initialBalance,intrestRate);
	boolean running = true;
	while(running) {
		System.out.println("***********Bank Menu***********");
		System.out.println("1.Deposite");
		System.out.println("2.WithDraw");
		System.out.println("3.Show Balance");
		System.out.println("4.Show Transaction Histroy");
		System.out.println("5.Apply Intrest");
		System.out.println("6.Exit");
		System.out.println("Enter Your Choice :");
		int choice = sc.nextInt();
		switch(choice) {
		case 1 :
			System.out.println("Enter Deposite amount:");
			account.deposit(sc.nextDouble());
			break;
		case 2 :
			System.out.println("Enter withdrwal amount :");
			account.withdraw(sc.nextDouble());
			break;
		case 3 :
			account.showBalance();
			break;
		case 4 :
			account.showTransactionHistroy();
			break;
		case 5 :
			account.applyIntrest();
		case 6 :
			running = false;
			System.out.println("Thank You for using the bank system!");
			break;
			default :
				System.out.println("Invalid choice.Try again.");
		
		}
		
	}
	sc.close();

	}

}

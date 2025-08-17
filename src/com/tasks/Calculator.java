package com.tasks;

import java.util.Scanner;

public class Calculator {
	
	public static double add( double a ,double b) {
		return a+b;
		
		
	}
	public static double substract(double a ,double b) {
		return a-b;
		
	}
	public static double multiply(double a ,double b) {
		return a*b;
		
	}
	public static double division(double a ,double b) {
		if(b==0) {
			System.err.println("Error : Cannot divide by zero");
			return 0;
		}
		return a/b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 boolean running = true;
		
		System.out.println("****Java Console Calculator****");
		System.out.println("Choose an operation :");
		System.out.println("1.Add");
		System.out.println("2.Substract");
		System.out.println("3.Multiply");
		System.out.println("4.Divide");
		System.out.println("5.Exit");
		System.out.println("Enter your choice (1-5) :");
		int choice = sc.nextInt();
		if(choice == 5) {
			running = false;
			System.out.println("Exiting Calculator . Good Bye!");
			
		}
		   while (running) {
		System.out.println("Enter First Number :");
		double num1 = sc.nextDouble();
		System.out.println("Enter Second Number :");
		double num2 = sc.nextDouble();
		double result;
		switch(choice) {
		case 1 :
			result = add(num1 , num2);
			System.out.println("Result :" + result);
			break;
		case 2 :
			result = substract(num1,num2);
			System.out.println("Result :" + result);
			break;
		case 3 :
			result = multiply(num1,num2);
			System.out.println("Result :"+ result);
			break;
		case 4	:
			result = division(num1,num2);
			if(num2 != 0) {
			System.out.println("Result :"+ result);
			}
			break;
	
		
		default :
		System.out.println("invalid choice .please try again!!!");
		}
		
		}
		   sc.close();
		   
}
}


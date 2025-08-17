package com.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ArrayList<Book> books = new ArrayList<>();
	        ArrayList<User> users = new ArrayList<>();

	        boolean running = true;

	        while (running) {
	            System.out.println("***** Library Management System***** ");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add User");
	            System.out.println("3. View All Books");
	            System.out.println("4. View All Users");
	            System.out.println("5. Issue Book to User");
	            System.out.println("6. Return Book from User");
	            System.out.println("7. View User's Issued Books");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Book ID: ");
	                    int bookId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Book Title: ");
	                    String title = sc.nextLine();
	                    System.out.print("Enter Book Author: ");
	                    String author = sc.nextLine();
	                    books.add(new Book(bookId, title, author));
	                    System.out.println(" Book added.");
	                    break;

	                case 2:
	                    System.out.print("Enter User ID: ");
	                    int userId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter User Name: ");
	                    String name = sc.nextLine();
	                    users.add(new User(userId, name));
	                    System.out.println(" User added.");
	                    break;

	                case 3:
	                    if (books.isEmpty()) {
	                        System.out.println(" No books available.");
	                    } else {
	                        System.out.println(" All Books:");
	                        for (Book b : books) {
	                            System.out.println(b);
	                        }
	                    }
	                    break;

	                case 4:
	                    if (users.isEmpty()) {
	                        System.out.println(" No users found.");
	                    } else {
	                        System.out.println(" All Users:");
	                        for (User u : users) {
	                            System.out.println(u);
	                        }
	                    }
	                    break;

	                case 5:
	                    System.out.print("Enter User ID: ");
	                    int issueUserId = sc.nextInt();
	                    sc.nextLine();
	                    User issueUser = findUserById(users, issueUserId);
	                    if (issueUser == null) {
	                        System.out.println(" User not found.");
	                        break;
	                    }

	                    System.out.print("Enter Book ID to issue: ");
	                    int issueBookId = sc.nextInt();
	                    Book issueBook = findBookById(books, issueBookId);
	                    if (issueBook == null) {
	                        System.out.println(" Book not found.");
	                    } else if (issueBook.isIssued()) {
	                        System.out.println(" Book already issued.");
	                    } else {
	                        issueUser.issueBook(issueBook);
	                        System.out.println(" Book issued to " + issueUser.getName());
	                    }
	                    break;

	                case 6:
	                    System.out.print("Enter User ID: ");
	                    int returnUserId = sc.nextInt();
	                    User returnUser = findUserById(users, returnUserId);
	                    if (returnUser == null) {
	                        System.out.println(" User not found.");
	                        break;
	                    }

	                    System.out.print("Enter Book ID to return: ");
	                    int returnBookId = sc.nextInt();
	                    boolean returned = returnUser.returnBook(returnBookId);
	                    if (returned) {
	                        System.out.println(" Book returned.");
	                    } else {
	                        System.out.println(" This user hasn't issued that book.");
	                    }
	                    break;

	                case 7:
	                    System.out.print("Enter User ID: ");
	                    int viewUserId = sc.nextInt();
	                    User viewUser = findUserById(users, viewUserId);
	                    if (viewUser != null) {
	                        viewUser.showIssuedBooks();
	                    } else {
	                        System.out.println(" User not found.");
	                    }
	                    break;

	                case 8:
	                    running = false;
	                    System.out.println(" Exiting... Bye!");
	                    break;

	                default:
	                    System.out.println(" Invalid choice.");
	            }
	        }

	        sc.close();
	    }

	   
	    private static Book findBookById(ArrayList<Book> books, int id) {
	        for (Book b : books) {
	            if (b.getId() == id) return b;
	        }
	        return null;
	    }

	    private static User findUserById(ArrayList<User> users, int id) {
	        for (User u : users) {
	            if (u.getId() == id) return u;
	        }
	        return null;
	    }
	}




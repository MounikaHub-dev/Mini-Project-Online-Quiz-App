package com.task3;

import java.util.ArrayList;

public class User {
	private int id;
	private String name;
	private ArrayList<Book> issuedBooks;

	public User(int id, String name) {
		
		this.id = id;
		this.name = name;
		this.issuedBooks = new ArrayList<>();
	}

	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void issueBook(Book book) {
		issuedBooks.add(book);
		book.issue();
	}

	public boolean returnBook(int bookId) {
		for (Book book : issuedBooks) {
			if (book.getId() == bookId) {
				book.returnBook();
				issuedBooks.remove(book);
				return true;
			}
		}
		return false;
	}

	public void showIssuedBooks() {
		if (issuedBooks.isEmpty()) {
			System.out.println("No books issued by " + name);
		} else {
			System.out.println("Books issued by " + name + ":");
			for (Book book : issuedBooks) {
				System.out.println(book);
			}
		}
	}

	@Override
	public String toString() {
		return "User ID: " + id + ", Name: " + name + ", Books Issued: " + issuedBooks.size();
	}
}

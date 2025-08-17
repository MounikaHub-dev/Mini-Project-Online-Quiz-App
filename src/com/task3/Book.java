package com.task3;

public class Book {
	private int id;
	private String title;
	private String author;
	private boolean isIssued;
	 public Book(int id,String title,String author) {
		 this.id = id;
		 this.author = author;
		 this.title = title;
		 this.isIssued = false;
		 
	 }
	 public int getId() { 
		 return id;
	 }
	    public String getTitle() { 
	    	return title; 
	    	}
	    public String getAuthor() { 
	    	return author; 
	    	}
	    public boolean isIssued() { 
	    	return isIssued; 
	    	}
	    public void issue() {
	    	isIssued = true;
	    }
	  
public void returnBook() {
	isIssued = false;
}
public String getStatus() {
	return isIssued? "Issued": "Available";
}
@Override
public String toString() {
    return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Status: " + getStatus();
}
}

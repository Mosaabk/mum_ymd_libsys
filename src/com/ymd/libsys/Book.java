package com.ymd.libsys;

public class Book {
	private String ISBN;
	private String title;
	private int borrowLimit;
	
	
	public Book(String ISBN, String title, int borrowLimit) {
		this.ISBN = ISBN;
		this.title = title;
		this.borrowLimit = borrowLimit;
	}
	
	
}

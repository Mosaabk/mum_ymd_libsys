package com.ymd.libsys;

import java.util.List;

public class Book {
	private String ISBN;
	private String title;
	private int borrowLimit;
	
	private List<Author> authors;
	
	
	public Book(String ISBN, String title, int borrowLimit) {
		this.ISBN = ISBN;
		this.title = title;
		this.borrowLimit = borrowLimit;
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
	
}

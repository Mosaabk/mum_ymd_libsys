package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String ISBN;
	private String title;
	private int borrowLimit;
	
	private List<Author> authors;
	

	public Book() {
		super();
		this.authors = new ArrayList<Author>();
	}
	
	public Book(String ISBN, String title, int borrowLimit) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.borrowLimit = borrowLimit;
		this.authors = new ArrayList<Author>();
	}
	
	public void addAuthors(Author authors) {
		this.authors.add(authors);
	}
	
	
	
}

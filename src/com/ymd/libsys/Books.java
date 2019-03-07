package com.ymd.libsys;

import java.util.HashMap;

public class Books {

	private HashMap<String, Book> books;
	
	public Books() {
		books = new HashMap<String, Book>();
	}

	public HashMap<String, Book> getBooks() {
		return books;
	}

	public void setBooks(HashMap<String, Book> books) {
		this.books = books;
	}
	
}

package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

public class Books {

	private List<Book> books;
	
	public Books() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}

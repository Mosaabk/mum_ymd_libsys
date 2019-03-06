package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

public class BookCopies {
	
	private List<BookCopy> bookCopies;
	
	public BookCopies() {
		bookCopies = new ArrayList<BookCopy>();
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

}

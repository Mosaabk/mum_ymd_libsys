package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Book {
	private String ISBN;


	private String title;
	private int borrowLimit;
	
	private List<Author> authors;
	private List<BookCopy> copies;
	

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
		this.copies = new ArrayList<BookCopy>();
		addCopy();
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void addAuthors(Author authors) {
		this.authors.add(authors);
	}
	

	public static void addBook(Book b) {
		String bPath = "src/com/ymd/libsys/dataaccess/Books";
		String res = MyTool.readStringFromFile(bPath);
		Books books;
		String booksString;
		if (res.equals("")) {
			books = new Books();
			books.getBooks().put(b.ISBN, b);
			booksString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(booksString, bPath);
		} else {
			String jsonDataString = MyTool.readStringFromFile(bPath);
			books = JSON.parseObject(jsonDataString, Books.class);
			books.getBooks().put(b.ISBN, b);
			booksString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(booksString, bPath);
		}
	}
	
	public void addCopy() {
		this.copies.add(new BookCopy(this.copies.size()+1));
	}
	
	
}

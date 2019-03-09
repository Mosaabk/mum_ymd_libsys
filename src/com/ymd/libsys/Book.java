package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Book {
	public String ISBN;


	public String title;
	public int borrowLimit;
	
	public List<Author> authors;
	public List<BookCopy> copies;
	
	public String getTitle() {
		return this.title;
	}
//	public String getborrowLimit() {
//		String s = borrowLimit.g
//		return "test";
//	}
	public Book() {
		super();
		this.authors = new ArrayList<Author>();
		this.copies = new ArrayList<BookCopy>();
	}
	
	public Book(String ISBN, String title, int borrowLimit) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.borrowLimit = borrowLimit;
		this.authors = new ArrayList<Author>();
		this.copies = new ArrayList<BookCopy>();
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public int getCopyNum() {
		return copies.size();
	}
	
	public String getAuthorsAll() {
		StringBuilder sb = new StringBuilder();
		
		for(Author author: authors) {
			sb.append(author.getFirstName() +" " + author.getLastName());
		}
		return sb.toString();
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	

	public static void addBook(Book b) {
		String bPath = "src/com/ymd/libsys/dataaccess/books";
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
	
	public int addCopy() {
		this.copies.add(new BookCopy(this.copies.size()+1));
		return this.copies.size();
	}
	
	public boolean editBook(Book b) {
		boolean result = false;

		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/books";
			String res = MyTool.readStringFromFile(filePath);
			Books books;
			if (!res.equals("")) {
				books = JSON.parseObject(res, Books.class);
			}
			else {
				books = new Books();
			}
			
			books.getBooks().remove(this.ISBN);
			books.getBooks().put(this.ISBN, b);
			
			String membersString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(membersString, filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return result;
	}
	public static Book getBook(String isbn) {
		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/books";
			String res = MyTool.readStringFromFile(filePath);
			Books books;
			if (!res.equals("")) {
				books = JSON.parseObject(res, Books.class);
			}
			else {
				books = new Books();
			}

			return books.getBooks().get(isbn);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		

		return null;
		
	}
	
}

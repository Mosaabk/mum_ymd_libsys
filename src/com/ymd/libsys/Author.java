package com.ymd.libsys;

import java.util.List;

public class Author extends Person {
	Person personalData;
	String shortBio;
	String credentials;
	List<Book> books;
	
	public Author(String firstname, String lastName, String phone, Address address, String credentials, String shortBio, List<Book> books) {
		super(firstname, lastName, phone, address);
		this.credentials = credentials;
		this.books  = books;
	}

	public Person getPersonalData() {
		return personalData;
	}

	public void setPersonalData(Person personalData) {
		this.personalData = personalData;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}

package com.ymd.libsys;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class Author extends Person {
	private int id;
	private int index;
	Person personalData;
	String shortBio;
	String credentials;
	List<Book> books;
	
	public Author() {
		super();
	}
	
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
	
	public void addAuthor() {}
	public void editAuthor() {}
	public void getAuthor() {}
	
	public static Author addAuthor(String firstName, String lastName, String phoneNum, Address address) {
		Author author = new Author(firstName, lastName, phoneNum, address);
		author.id = 0;

		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/authors";
			String res = MyTool.readStringFromFile(filePath);
			Authors authors;
			if (!res.equals("")) {
				authors = JSON.parseObject(res, Authors.class);
				author.id = authors.getAuthors().size();
			}
			else {
				authors = new Authors();
			}
			author.id = author.id>0? author.id + 10001 : 10001;
			
			authors.getAuthors().add(author);
			String authorsString = JSON.toJSONString(authors);
			MyTool.WriteStringToFile(authorsString, filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return author;
	}
	
	public Author(String firstName, String lastName, String phoneNum, Address address){
		super(firstName, lastName, phoneNum, address);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Author getAuthor(int id) {
		try {
			
			String filePath = "src/com/ymd/libsys/authors";
			String res = MyTool.readStringFromFile(filePath);
			Authors authors;
			if (!res.equals("")) {
				authors = JSON.parseObject(res, Authors.class);
			}
			else {
				authors = new Authors();
			}
			
			for(int i = 0; i< authors.getAuthors().size(); i++) {
				Author mi = authors.getAuthors().get(i);
				if(mi.getId() == id)
				{
					mi.index = i;
					return mi;
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		

		return null;
	}
	
	public boolean editAuthor(Author m) {
		boolean result = false;

		try {
			
			String filePath = "src/com/ymd/libsys/authors";
			String res = MyTool.readStringFromFile(filePath);
			Authors authors;
			if (!res.equals("")) {
				authors = JSON.parseObject(res, Authors.class);
			}
			else {
				authors = new Authors();
			}
			
			authors.getAuthors().set(this.index, m);
			String authorsString = JSON.toJSONString(authors);
			MyTool.WriteStringToFile(authorsString, filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return result;
	}
	


	
}

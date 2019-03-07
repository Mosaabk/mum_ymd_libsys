package com.ymd.libsys;

import com.alibaba.fastjson.JSON;

public class Administrator {
	
	public static void addNewBook(Book book) {
		String booksPath = "src/com/ymd/libsys/dataaccess/books";
		String res = MyTool.readStringFromFile(booksPath);
		if (res.equals("")) {
			Books books = new Books();
			books.getBooks().add(book);
			String bookString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(bookString, booksPath);
		} else {
			Books books = JSON.parseObject(res, Books.class);
			books.getBooks().add(book);
			String bookString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(bookString, booksPath);
		}
	}
	
	public static void addCopyBook(BookCopy bookCopy) {
		String bookCopiesPath = "src/com/ymd/libsys/bookCopies";
		String res = MyTool.readStringFromFile(bookCopiesPath);
		if (res.equals("")) {
			BookCopies bookCopies = new BookCopies();
			bookCopies.getBookCopies().add(bookCopy);
			String bookCopiesString = JSON.toJSONString(bookCopies);
			MyTool.WriteStringToFile(bookCopiesString, bookCopiesPath);
		} else {
			BookCopies bookCopies = JSON.parseObject(res, BookCopies.class);
			bookCopies.getBookCopies().add(bookCopy);
			String bookCopiesString = JSON.toJSONString(bookCopies);
			MyTool.WriteStringToFile(bookCopiesString, bookCopiesPath);
		}
	}
	
	public static void addLibraryMember(Member member) {
		String membersPath = "src/com/ymd/libsys/members";
		String res = MyTool.readStringFromFile(membersPath);
		if (res.equals("")) {
			Members members = new Members();
			member.setId(0);
			members.getMembers().add(member);
			String memberString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(memberString, membersPath);
		} else {
			Members members = JSON.parseObject(res, Members.class);
			
			int len = members.getMembers().size();
			int lastId = members.getMembers().get(len - 1).getId();
			lastId++;
			member.setId(lastId);
			
			members.getMembers().add(member);
			String memberString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(memberString, membersPath);
		}
		
	}
	
	public static void EditLibraryMember(Member member) {
		String membersPath = "src/com/ymd/libsys/members";
		String jsonDataString = MyTool.readStringFromFile(membersPath);
		Members members = JSON.parseObject(jsonDataString, Members.class);
		members.getMembers().set(member.getId(), member);
		String memberString = JSON.toJSONString(members);
		MyTool.WriteStringToFile(memberString, membersPath);
	}
	
	public static void main(String[] args) {
      
      
  }

}

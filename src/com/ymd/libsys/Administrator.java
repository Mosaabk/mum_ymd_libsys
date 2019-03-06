package com.ymd.libsys;

import com.alibaba.fastjson.JSON;

public class Administrator {
	
	public static void addNewBook(Book book) {
		String booksPath = "src/com/ymd/libsys/books";
		String res = MyTool.readStringFromFile(booksPath);
		if (res.equals("")) {
			Books books = new Books();
			books.getBooks().add(book);
			String bookString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(bookString, booksPath);
		} else {
			String jsonDataString = MyTool.readStringFromFile(booksPath);
			Books books = JSON.parseObject(jsonDataString, Books.class);
			
			books.getBooks().add(book);
			String bookString = JSON.toJSONString(books);
			MyTool.WriteStringToFile(bookString, booksPath);
		}
	}
	
	public static void addCopyBook(BookCopy bookCopy) {
		
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
			String jsonDataString = MyTool.readStringFromFile(membersPath);
			Members members = JSON.parseObject(jsonDataString, Members.class);
			
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

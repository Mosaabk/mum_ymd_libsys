package com.ymd.libsys;

public class Member extends Person {
	private int id;
	
	Member(String firstName, String lastName, String phoneNum, Address address){
		super(firstName, lastName, phoneNum, address);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

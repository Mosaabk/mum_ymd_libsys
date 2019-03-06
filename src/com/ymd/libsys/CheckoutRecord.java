package com.ymd.libsys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckoutRecord {
	
	private Member member;
	
	Date checkoutDate;
	Date dueDate;
	
	List<Fine> fines;
	List<CheckoutEntry> checkoutEntry = new ArrayList<>();
	
	
	public void addCheckoutEntry(CheckoutEntry entry) {
		checkoutEntry.add(entry);
	}
	
	
	public Member getMember() {
		return this.member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	
}

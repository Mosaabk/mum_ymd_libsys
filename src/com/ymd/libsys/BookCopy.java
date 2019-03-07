package com.ymd.libsys;

public class BookCopy {
	public int copyId;
	public boolean isCheckedout;
	
	public BookCopy(){
		super();
	}
	public BookCopy( int copyId){
		super();
		this.copyId = copyId;
		this.isCheckedout = false;
	}
	
	
}

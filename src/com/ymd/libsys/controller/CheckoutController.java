package com.ymd.libsys.controller;

import com.ymd.libsys.Book;
import com.ymd.libsys.BookCopy;
import com.ymd.libsys.Books;
import com.ymd.libsys.CheckoutEntry;
import com.ymd.libsys.CheckoutRecord;
import com.ymd.libsys.Member;
import com.ymd.libsys.ui.SystemObj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CheckoutController {
	CheckoutRecord r;
	@FXML
	private TextField copyNum;
	
	@FXML
	private TextField memberId;
	
	@FXML
	private TextField bookTitle;
	
	@FXML
	private TableView<CheckoutEntry> checkoutTV;
	
	@FXML
	private TableColumn<CheckoutEntry, String> copyNo;
	@FXML
	private TableColumn<CheckoutEntry, String> title;
	@FXML
	private TableColumn<CheckoutEntry, String> checkoutDate;
	@FXML
	private TableColumn<CheckoutEntry, String> dueDate;

	@FXML
	private Label resultMsg;
	
	


	@FXML
	private Button addBtn;
	@FXML
	private Button editBtn;
	
	
	@FXML
	public void printRecord() {
		if(r!= null) {
			System.out.println(r.toString());
		}
	}
	
	@FXML
	public void checkoutBook() {
		boolean result = false;
		try {
			if(r == null) {
				r = new CheckoutRecord();
				Member member = Member.getMember(Integer.valueOf(memberId.getText()));
				if(member != null)
				r.setMember(member);
			}
			Book thisBook = Book.getBook(bookTitle.getText());
			if(thisBook!= null && r.getMember()!= null) {
				for (int i = 0; i<  thisBook.copies.size(); i++) {
					BookCopy c = thisBook.copies.get(i);
					if(!c.isCheckedout) {
						c.isCheckedout = true;
						thisBook.editBook(thisBook);
						resultMsg.setText("OK");
						r.checkoutEntry.add(new CheckoutEntry(c));
						result = true;
						break;
					}
				}
			}
		}
		catch(Exception ex) {}
			
			if(!result)
			resultMsg.setText("This Book not avaliable, or Bad Entry");
	}
	
	@FXML
	public void back() {
		SystemObj.openMenu();
	}
	
}

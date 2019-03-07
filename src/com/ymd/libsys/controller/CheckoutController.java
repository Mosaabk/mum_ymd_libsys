package com.ymd.libsys.controller;

import com.ymd.libsys.Book;
import com.ymd.libsys.BookCopy;
import com.ymd.libsys.Books;
import com.ymd.libsys.CheckoutEntry;
import com.ymd.libsys.ui.SystemObj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CheckoutController {
	
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
		
	}
	
	@FXML
	public void checkoutBook() {
		boolean result = false;
		Book thisBook = Book.getBook(bookTitle.getText());
		if(thisBook!= null) {
			for (int i = 0; i<  thisBook.copies.size(); i++) {
				BookCopy c = thisBook.copies.get(i);
				if(!c.isCheckedout) {
					c.isCheckedout = true;
					thisBook.editBook(thisBook);
					resultMsg.setText("OK");
					result = true;
					break;
				}
			}
		}
		if(!result)
		resultMsg.setText("This Book not avaliable");
	}
	
	@FXML
	public void back() {
		SystemObj.openMenu();
	}
	
}

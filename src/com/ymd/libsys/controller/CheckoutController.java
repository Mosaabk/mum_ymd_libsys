package com.ymd.libsys.controller;

import com.ymd.libsys.CheckoutEntry;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CheckoutController {

	@FXML
	private TextField copyNum;
	@FXML
	private TextField title;
	@FXML
	private TextField checkoutDate;
	@FXML
	private TextField dueDate;
	
	@FXML
	private TextField memberId;
	
	@FXML
	private TextField bookTitle;
	
	
	
	@FXML
	private TableView<CheckoutEntry> checkoutTV;

	@FXML
	private Button addBtn;
	@FXML
	private Button editBtn;
	
	
	@FXML
	public void printRecord() {
		
	}
	
}

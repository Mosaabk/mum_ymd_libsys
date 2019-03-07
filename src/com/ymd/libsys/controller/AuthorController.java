package com.ymd.libsys.controller;

import com.ymd.libsys.Address;
import com.ymd.libsys.Author;
import com.ymd.libsys.Member;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthorController {
	@FXML
	private TextField authorId;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField phone;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField street;
	@FXML
	private TextField zip;
	
	@FXML
	private Button addBtn;
	@FXML
	private Button editBtn;
	
	

	@FXML
	public void  addAuthor() {
		Address address = new Address(street.getText(),city.getText(),state.getText(),zip.getText());
		Author author = Author.addAuthor(firstName.getText(), lastName.getText(), phone.getText(), address);
		
		memberId.setText(String.valueOf(m.getId()));
	}
	
	@FXML
	public void  getAuthor() {
		Author m = Author.getAuthor(Integer.valueOf( authorId.getText()));
		if(m != null && m.getId()>= 0) {
			firstName.setText(m.getFirstName());
			lastName.setText(m.getLastName());
			phone.setText(m.getPhoneNum());
			if(m.getAddress()!=null) {
				city.setText(m.getAddress().city);
				state.setText(m.getAddress().state);
				street.setText(m.getAddress().street);
				zip.setText(m.getAddress().zipCode);
			}
		}
	}
	@FXML
	public void editAuthor() {
		try {
			Author m = Author.getAuthor(Integer.valueOf( authorId.getText()));

			Address address = new Address(street.getText(),city.getText(),state.getText(),zip.getText());
			Author mn = new Author(firstName.getText(), lastName.getText(), phone.getText(), address);
			mn.setId(Integer.valueOf( authorId.getText()));
			m.editAuthor(mn);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

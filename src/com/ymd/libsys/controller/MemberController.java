	package com.ymd.libsys.controller;

import com.ymd.libsys.Address;
import com.ymd.libsys.Member;
import com.ymd.libsys.ui.SystemObj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class MemberController {
	
	@FXML
	private TextField memberId;
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
	private void close() {
		SystemObj.openMenu();
	}

	@FXML
	public void  addMember() {
		Address address = new Address(street.getText(),city.getText(),state.getText(),zip.getText());
		Member m = Member.addMember(firstName.getText(), lastName.getText(), phone.getText(), address);
		
		memberId.setText(String.valueOf(m.getId()));
	}
	
	@FXML
	public void  getMember() {
		Member m = Member.getMember(Integer.valueOf( memberId.getText()));
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
	public void editMember() {
		try {
			Member m = Member.getMember(Integer.valueOf( memberId.getText()));

			Address address = new Address(street.getText(),city.getText(),state.getText(),zip.getText());
			Member mn = new Member(firstName.getText(), lastName.getText(), phone.getText(), address);
			mn.setId(Integer.valueOf( memberId.getText()));
			m.editMember(mn);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}


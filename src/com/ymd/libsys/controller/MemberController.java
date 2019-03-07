package com.ymd.libsys.controller;
import javafx.concurrent.Task;

import com.alibaba.fastjson.JSON;
import com.ymd.libsys.Address;
import com.ymd.libsys.Member;

import com.ymd.libsys.Members;
import com.ymd.libsys.MyTool;
import com.ymd.libsys.ui.SystemObj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



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
	private TableView<Member> memberTable;
	
	@FXML
	private TableColumn<Member, String> memberIdT;
	
	@FXML
	private TableColumn<Member, String> firstNameT;
	@FXML
	private TableColumn<Member, String> lastNameT;
	@FXML
	private TableColumn<Member, String> phoneNumT;
	@FXML
	private TableColumn<Member, String> streetT;
	@FXML
	private TableColumn<Member, String> cityT;
	@FXML
	private TableColumn<Member, String> stateT;
	@FXML
	private TableColumn<Member, String> zipcodeT;
		
	
	
	   @FXML
	    private void initialize() 
	    {
		   try {
		   memberIdT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"id"));
		   
		   firstNameT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"firstName"));
		   lastNameT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"lastName"));
		   phoneNumT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"phoneNum"));
		   streetT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"street"));
		   cityT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"city"));
		   stateT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"state"));
		   zipcodeT.setCellValueFactory(new PropertyValueFactory<Member, String>(
					"zipcode"));
		   
		   listMembers();  
		   }
		   catch(Exception ex) {}
		   
	    }
	   
    @FXML
    public void listMembers(){
        Task<ObservableList<Member>> task = new GetAllMembers();
        memberTable.itemsProperty().bind(task.valueProperty());

//        task.setOnSucceeded(e -> progressBar.setVisible(false));
//        task.setOnFailed(e -> progressBar.setVisible(false));
        new Thread(task).start();
     }
	
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
	
	public void goToAdd() {
		SystemObj.openWindow("Member", this);
	}
	
	public void goToEdit() {
		Member m = memberTable.getSelectionModel().getSelectedItem();
		
		System.out.println(m.getId());

	}
	class GetAllMembers extends Task {

	    @Override
	    public ObservableList<Member> call(){
	    	String filePath = "src/com/ymd/libsys/dataaccess/members";
			String res = MyTool.readStringFromFile(filePath);
			Members members = JSON.parseObject(res, Members.class);
			
	        return FXCollections.observableArrayList(members.getMembers());
	               

	    }


	}
}


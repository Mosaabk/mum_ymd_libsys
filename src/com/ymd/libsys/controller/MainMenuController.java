package com.ymd.libsys.controller;

import com.ymd.libsys.ui.SystemObj;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {
	
	@FXML
	private Button btnAddMem;
	@FXML
	private Button btnEditMem;
	@FXML
	private Button btnAddBook;
	@FXML
	private Button btnBookList;
	@FXML
	private Button btnCheckout;
	
	@FXML
	private Button btnShowMembers;
	
	@FXML
	private Button btnLogout;
	
	
   @FXML
    private void initialize() 
    {
        //
	   
    }

   public void setRoles(int r) {

	   btnAddMem.setVisible(false);
	   btnEditMem.setVisible(false);
	   btnAddBook.setVisible(false);
	   btnBookList.setVisible(false);
	   btnCheckout.setVisible(false);
	   btnShowMembers.setVisible(false);
	   if(r == 1 || r == 3) {
		   btnAddMem.setVisible(true);
		   btnEditMem.setVisible(true);
		   btnAddBook.setVisible(true);
		   btnBookList.setVisible(true);
		   btnShowMembers.setVisible(true);
	   }
	   if(r == 2 || r == 3) {
		   btnCheckout.setVisible(true);
	   }
   }


	@FXML
	public void addNewMember() {
		openScreen(3);
	}
	
	@FXML
	public void editMember() {
		openScreen(3);
	}
	
	@FXML
	public void checkoutBook() {
		openScreen(1);
	}
	
	@FXML
	public void addBook() {
		openScreen(5);
	}

	@FXML
	public void goToBookList() {
		openScreen(0);
	}
	
	
	@FXML
	public void showMembers() {
		openScreen(4);
	}
	
	@FXML
	public void logOut() {
		SystemObj.openLogin();
	}

    private void openScreen(int s) {
    	String screen = "";
    	switch(s) {
    	case 0:
    		screen = "Book";
    		break;
    	case 1:
    		screen = "Checkout";
    		break;
    	case 2:
    		screen = "CheckoutTable";
    		break;
    	case 3:
    		screen = "Member";
    		break;
    	case 4:
    		screen = "MemberList";
    		break;
    	case 5:
    		screen = "NewBookForm";
    		break;
    	}
    	
    	SystemObj.openWindow(screen, this);
    }
}

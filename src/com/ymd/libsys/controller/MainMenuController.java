package com.ymd.libsys.controller;

import java.io.InputStream;

import com.ymd.libsys.ui.SystemObj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
	
	
	@FXML
	private Button btnAddMem;
	@FXML
	private Button btnEditMem;
	@FXML
	private Button btnAddBook;
	@FXML
	private Button btnAddCopy;
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
	   btnAddCopy.setVisible(false);
	   btnCheckout.setVisible(false);
	   if(r == 1 || r == 3) {
		   btnAddMem.setVisible(true);
		   btnEditMem.setVisible(true);
		   btnAddBook.setVisible(true);
		   btnAddCopy.setVisible(true);
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
	public void addCopy() {
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

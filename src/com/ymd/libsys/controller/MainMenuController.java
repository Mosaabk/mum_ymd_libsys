package com.ymd.libsys.controller;

import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

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
	
	}
	
	@FXML
	public void editMember() {
		
	}
	
	@FXML
	public void checkoutBook() {
		
	}
	
	@FXML
	public void addBook() {
		
	}
	
	@FXML
	public void addCopy() {
		
	}
}

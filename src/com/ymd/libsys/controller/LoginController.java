package com.ymd.libsys.controller;

import com.ymd.libsys.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//import javafx.scene.control.Alert.AlertType;
import com.ymd.libsys.SystemUser;


import javafx.stage.Stage;


public class LoginController {

    @FXML
    private TextField tf;

    @FXML
    private PasswordField pf;

    @FXML
    private Button btn;

    @FXML
    private void initialize() 
    {
        btn.setVisible(true);
    }
    public void submit(ActionEvent ae) {
//        Alert alert = new Alert(AlertType.INFORMATION);

        String s1, s2;

        s1 = tf.getText();

        s2 = pf.getText();
        

        System.out.println(s1 + " " + s2);

        SystemUser su = new SystemUser(s1, s2);
        int loginRes = su.login(s1, s2);
        loginRes = 3;


//        alert.setTitle("Login ... Test!");

        int screen = -1;

        System.out.println(su.getRole());

        switch (loginRes){
            case 0:
                System.out.println("fail");
                break;
            case 1:
                System.out.println("System User");
                screen = 0;
                break;
            case 2:
                System.out.println("Admin");
                screen = 1;
                break;
            case 3:
                System.out.println("Librarian");
                screen = 2;
                break;
            case 4:
                System.out.println("Super User");
                screen = 3;
                break;

        }

        openScreen(screen);

        //((ae.getSource())).getScene().getWindow().hide();


    }
    
    private void openScreen(int s) {
    	String screen = "";
    	switch(s) {
    	case 0:
    		screen = "";
    		break;
    	case 1:
    		screen = "Book";
    		break;
    	case 2:
    		screen = "Checkout";
    		break;
    	case 3:
    		screen = "Member";
    		break;
    	}
    	
    	try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ymd/libsys/view/" + screen + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
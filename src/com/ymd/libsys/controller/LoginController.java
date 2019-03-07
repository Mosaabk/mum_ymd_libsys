package com.ymd.libsys.controller;


import com.ymd.libsys.SystemUser;
import com.ymd.libsys.ui.SystemObj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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

        String s1, s2;

        s1 = tf.getText();

        s2 = pf.getText();
        

        System.out.println(s1 + " " + s2);

        SystemUser su = new SystemUser(s1, s2);
        int loginRes = su.login(s1, s2);

        int screen = -1;

        System.out.println(su.getRole());

        switch (loginRes){
            case -1:
                System.out.println("fail");
                break;
            case 1:
                System.out.println("Super User");
                screen = 3;
                break;
            case 2:
                System.out.println("Admin");
                screen = 1;
                break;
            case 3:
                System.out.println("Librarian");
                screen = 2;
                break;

        }

        openScreen(screen, ae);



    }
    
    private void openScreen(int s, ActionEvent ae) {
    	String screen = "MainMenu";
    	
    	try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ymd/libsys/view/" + screen + ".fxml"));
            
			Parent root1 = (Parent) fxmlLoader.load();
			
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            
			MainMenuController controller = fxmlLoader.<MainMenuController>getController();
			controller.setRoles(s);
			
			SystemObj.lw = ((Node)ae.getSource()).getScene().getWindow();
			SystemObj.lw.hide();
			
			SystemObj.mw = SystemObj.cw = stage.getScene().getWindow();
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
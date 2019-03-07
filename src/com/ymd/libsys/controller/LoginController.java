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
import javafx.scene.control.Label;
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
    private Label err;
    
    @FXML
    private void initialize() 
    {
        btn.setVisible(true);
    }
    public void submit(ActionEvent ae) {

        String s1, s2;

        s1 = tf.getText();

        s2 = pf.getText();
        
        SystemUser su = new SystemUser(s1, s2);
        int loginRes = su.login(s1, s2);

        int screen = -1;
        err.setText("");
        switch (loginRes){
            case 3:
                screen = 3;
                break;
            case 1:
                screen = 1;
                break;
            case 2:
                screen = 2;
                break;
            default :
                System.out.println("fail");
                err.setText("Invalid login");
                break;

        }
        if(screen >= 1 && screen <=3) {
        	openScreen(screen, ae);

            pf.setText("");
        }



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
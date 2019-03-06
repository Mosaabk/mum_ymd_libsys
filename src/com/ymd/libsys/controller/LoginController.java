package com.ymd.libsys.controller;

import com.ymd.libsys.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
=======
//import javafx.scene.control.Alert;
>>>>>>> branch 'master' of https://github.com/Mosaabk/mum_ymd_libsys
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.stage.Stage;
=======
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/Mosaabk/mum_ymd_libsys
import javafx.scene.control.Alert.AlertType;
import com.ymd.libsys.SystemUser;
=======
//import javafx.scene.control.Alert.AlertType;
>>>>>>> branch 'master' of https://Mosaabk@github.com/Mosaabk/mum_ymd_libsys.git



public class LoginController {

    @FXML
    private TextField tf;

    @FXML
    private PasswordField pf;

    @FXML
    private Button btn;


    public void submit(ActionEvent ae) {
//        Alert alert = new Alert(AlertType.INFORMATION);

        String s1, s2;

        s1 = tf.getText();

        s2 = pf.getText();

        System.out.println(s1 + " " + s2);

        SystemUser su = new SystemUser(s1, s2);
<<<<<<< HEAD
        int loginRes = su.login(s1, s2);
        loginRes = 2;
=======

<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/Mosaabk/mum_ymd_libsys
        alert.setTitle("Login ... Test!");
<<<<<<< HEAD
        int screen = -1;
=======
        
        System.out.println(su.getRole());
=======
//        alert.setTitle("Login ... Test!");

>>>>>>> branch 'master' of https://github.com/Mosaabk/mum_ymd_libsys
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
<<<<<<< HEAD
        if(screen == 1) {
        	try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ymd/libsys/view/Book.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
=======
>>>>>>> branch 'master' of https://Mosaabk@github.com/Mosaabk/mum_ymd_libsys.git
>>>>>>> branch 'master' of https://github.com/Mosaabk/mum_ymd_libsys



    }
}
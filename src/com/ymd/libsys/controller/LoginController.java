package com.ymd.libsys.controller;

import com.ymd.libsys.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
<<<<<<< HEAD
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
        alert.setTitle("Login ... Test!");
        
        System.out.println(su.getRole());
=======
//        alert.setTitle("Login ... Test!");

        switch (loginRes){
            case 0:
                System.out.println("fail");
                break;
            case 1:
                System.out.println("System User");
                break;
            case 2:
                System.out.println("Admin");
            case 3:
                System.out.println("Librarian");
                break;

        }
>>>>>>> branch 'master' of https://Mosaabk@github.com/Mosaabk/mum_ymd_libsys.git



    }
}
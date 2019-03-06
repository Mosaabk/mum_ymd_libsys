package com.ymd.libsys.ui;

import com.ymd.libsys.Administrator;
import com.ymd.libsys.Member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        root = FXMLLoader.load(getClass().getResource("application.css"));

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        
//        Member member = new Member();
//		member.setId(1);
//		member.setFirstName("Tom");
//		member.setLastName("Bush");
//		member.setPhoneNum("13912345678");
//		Administrator.addLibraryMember(member);
    }
}

package com.ymd.libsys.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/ymd/libsys/view/login.fxml"));
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("/com/ymd/libsys/view/app.css").toExternalForm());
        
        
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        
    }
}

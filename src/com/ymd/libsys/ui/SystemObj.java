package com.ymd.libsys.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SystemObj {
	public static Window cw;
	public static Window mw;
	public static Window lw;
	
	public static void openWindow(String screen, Object o) {

    	try {

            FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource("/com/ymd/libsys/view/" + screen + ".fxml"));
            
			Parent root1 = (Parent) fxmlLoader.load();
			
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            
            SystemObj.cw.hide();
			SystemObj.cw = stage.getScene().getWindow();
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	public static void openMenu()
	{

		SystemObj.cw.hide();
		SystemObj.cw = SystemObj.mw;
        Stage stage = new Stage();
        stage.setScene(SystemObj.mw.getScene());  
        stage.show();
        SystemObj.mw = SystemObj.cw = stage.getScene().getWindow();
	}
	public static void openLogin()
	{

		SystemObj.cw.hide();

        Stage stage = new Stage();
        stage.setScene(SystemObj.lw.getScene());  
        stage.show();

        SystemObj.lw = SystemObj.cw = stage.getScene().getWindow();
	}
}

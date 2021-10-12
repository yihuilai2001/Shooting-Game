package a11_108403039;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class A11 extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("a11_108403039.fxml"));
          
        primaryStage.setTitle("GAME");
        Scene window = new Scene(root,400,300);
        window.getRoot().requestFocus();
        primaryStage.setScene(window);
        primaryStage.show();
    }
     


    public static void main(String[] args) {
        launch(args);
    }

	
}

package a11_108403039;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements EventHandler<KeyEvent>, Initializable{
	
	@FXML
	public Pane _field;
	@FXML
	public Label _plane;
	@FXML
	public Label _bullet;
	
	LinkedList<Label> _bullets = new LinkedList<Label>();
	
	public void handle(KeyEvent e) {
		if(e.getCode()==KeyCode.E) {
			Timeline barrel_roll = new Timeline(
			new KeyFrame(Duration.millis(1),
					(d)->{
						_plane.setRotate(_plane.getRotate()+1);
					}));
			barrel_roll.setCycleCount(360);
			barrel_roll.play();
		}
		if(e.getCode()==KeyCode.W) {
			_plane.setLayoutY(_plane.getLayoutY()-5);
		}
		if(e.getCode()==KeyCode.S) {
			_plane.setLayoutY(_plane.getLayoutY()+5);
		}
		if(e.getCode()==KeyCode.A) {
			_plane.setLayoutX(_plane.getLayoutX()-5);
		}
		if(e.getCode()==KeyCode.D) {
			_plane.setLayoutX(_plane.getLayoutX()+5);
		}
		if(e.getCode()==KeyCode.SPACE) {
			Label newBullet = new Label(_bullet.getText());
			newBullet.setLayoutX(_plane.getLayoutX()+_plane.getWidth());
			newBullet.setLayoutY(_plane.getLayoutY()+_plane.getHeight()/2);
			_bullets.push(newBullet);
			_field.getChildren().add(newBullet);
		}


	}
	
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000/60),(e)->{
			ArrayList<Label> tBullets = new ArrayList<Label>(_bullets);
			for(var b:tBullets) {
				b.setLayoutX(b.getLayoutX()+5);
				if(b.getLayoutX()>_field.getWidth()) {
					_bullets.remove(b);
					_field.getChildren().remove(b);
				}
			}
		}));
		fps.setCycleCount(Timeline.INDEFINITE);
		fps.play();
	}
	
}

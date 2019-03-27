package myPackage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserInterface extends Application implements Initializable {

	
	@FXML
	ChoiceBox preset;
	@FXML
	ChoiceBox game;
	@FXML
	ChoiceBox profile;
	@FXML
	Button play;
	@FXML
	Button event;
	@FXML
	TextField numRuns;
	@FXML
	CheckBox stopOnDeath;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
		final Pane p = loader.load();
		

		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	
		}
		
	
	
	

}

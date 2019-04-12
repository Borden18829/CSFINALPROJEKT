package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class UserInterface extends Application  implements Initializable {

	//declared data to be used in person
	public static String[] people = new String[10];
	public static ObservableList<String> list1 = FXCollections.observableArrayList();
	public static ObservableList<String> list2 = FXCollections.observableArrayList();
	public static ObservableList<String> list3 = FXCollections.observableArrayList();
	public static ObservableList<String> list4 = FXCollections.observableArrayList();
	public static ObservableList<String> list5 = FXCollections.observableArrayList();
	
	public static  VBox resultBOX = new VBox();
	
	//fxml buttons to initialize
	@FXML
	Button ClearName;
	@FXML
	ChoiceBox<String> preset;
	@FXML
	ChoiceBox<String> game;
	@FXML
	ChoiceBox<String> profile;
	@FXML
	Button play;
	@FXML
	Button event;
	@FXML
	ChoiceBox<String> numRuns;
	@FXML
	CheckBox stopOnFired;
	@FXML
	ChoiceBox<String> timeScaleChoice;
	@FXML
	ScrollPane resultBox;

//open scene from ui.fxml
//create printwriters to write to save files
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
		Pane p = loader.load();
		primaryStage.setTitle("J . A . N . K");
		primaryStage.setScene(new Scene(p));
		primaryStage.show();

		//when user closes application, write to corresponding save files
		primaryStage.setOnCloseRequest((WindowEvent event1) -> {

			try {

				PrintWriter out = new PrintWriter(new File("save.txt"));
				writeToSave(out, list3);

			} catch (FileNotFoundException e) {

			}
			try {

				PrintWriter out = new PrintWriter(new File("presets.txt"));
				writeToSave(out, list1);

			} catch (FileNotFoundException e) {

			}
		});

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	//method to print list into corresponding file via printwriter
	public void writeToSave(PrintWriter file_out, ObservableList<String> list) {
		for (int i = 0; i<list.size(); i++) {
			file_out.println(list.get(i));
		}
		file_out.close();

	}

	//method to read from save file and update string array that contains profiles
	public void readToSave() {
		try {
			Scanner in = new Scanner(new File("save.txt"));
			String s = new String(in.nextLine());

			if (s.equals("null") || s.equals("") || s.equals("Empty Slot") || s == null) {
				for (int i = 0; i < 9; i++) {
					people[i] = "Empty Slot";
				}
			} else {
				people[0] = s;
				for (int i = 1; i < 8; i++) {
					s = new String(in.nextLine());
					people[i] = s;
				}
			}

			in.close();
			// if file not found, create new file and fill with empty slot
		} catch (FileNotFoundException e) {
			new File("save.txt");
			for (int i = 0; i < 9; i++) {
				people[i] = new String("Empty Slot");
			}

		}

	}
	

}

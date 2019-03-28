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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class UserInterface extends Application implements Initializable {

	public static String[] people = new String[10];
	public static ObservableList<String> list1 = FXCollections.observableArrayList();
	public static ObservableList<String> list2 = FXCollections.observableArrayList();
	public static ObservableList<String> list3 = FXCollections.observableArrayList();

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

		primaryStage.setOnCloseRequest((WindowEvent event1) -> {

			try {

				PrintWriter out = new PrintWriter(new File("save.txt"));
				writeToSave(out);

			} catch (FileNotFoundException e) {

			}

		});

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void writeToSave(PrintWriter file_out) {
		for (int i = 0; i < 9; i++) {
			file_out.println(list3.get(i));
		}
		file_out.close();

	}

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
		} catch (FileNotFoundException e) {
			new File("save.txt");
			for (int i = 0; i < 9; i++) {
				people[i] = new String("Empty Slot");
			}

		}

	}

}

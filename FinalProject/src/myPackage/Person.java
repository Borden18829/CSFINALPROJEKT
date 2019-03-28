package myPackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Person extends UserInterface implements Initializable {

	
	public static String currentPerson = "Empty Slot";

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		list1.addAll("choice1", "choice2", "choice3");
		list2.addAll("choice4", "choice5", "choice6");
		
		readToSave();
		fillChoiceBox();
		
		game.setItems(list2);

		profile.getSelectionModel().select(0);

		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (currentPerson.equals("Empty Slot")) {
					createPerson();
					fillChoiceBox();
				}

			}

		});

		preset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				currentPerson = new String(preset.getValue());

			}

		});

	}

	public void createPerson() {
		final Pane p = new Pane();
		TextField text = new TextField();

		p.getChildren().add(text);

		Stage newStage = new Stage();
		newStage.setScene(new Scene(p));
		newStage.show();

		/*
		 * https://stackoverflow.com/questions/13880638/
		 * how-do-i-pick-up-the-enter-key-being-pressed- in-javafx2
		 */
		text.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					boolean check = false;
					for(int i = 0; i<9 && check == false; i++) {
						if(people[i] == null || people[i].equals("Empty Slot")) {
							people[i] = text.getText();
							check = true;
						}
					}
					
					list3.removeAll();
					fillChoiceBox();
					newStage.close();
					
				}
			}

		});

	}

	public void fillChoiceBox() {

		for (int i = 0; i < 9; i++) {
				list3.add(people[i]);
		}
		if (list3.size() > 10) {
			list3.remove(0, 9);
		}

		profile.setItems(list3);
		profile.getSelectionModel().select(0);
	}

}

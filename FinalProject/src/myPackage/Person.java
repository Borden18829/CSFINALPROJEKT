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
	public static int gameType = 0;
	public static int[] timeScale = { 1, 12, 365 };
	public static String currentPerson = "Empty Slot";
	public static boolean stopOnEvent = false;
	public static int numRuns1 = 0;
	public int currentPreset = 0;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// predetermined lists for choiceboxes
		list1.addAll("Normal", "Smoker", "Mountain-person", "Dare-devil");
		list2.addAll("Quick Game", "Detailed Game");
		list4.addAll("Years", "Months", "Days");
		list5.addAll("1", "2", "3", "4", "5");

		// when initialized, read from save file and fill profile choicebox
		readToSave();
		fillChoiceBox();

		// set other choiceboxes
		game.setItems(list2);
		preset.setItems((list1));
		timeScaleChoice.setItems((list4));
		numRuns.setItems(list5);

		// set choiceboxes to first choice in list
		timeScaleChoice.getSelectionModel().select(0);
		preset.getSelectionModel().select(0);
		game.getSelectionModel().select(0);
		profile.getSelectionModel().select(0);
		numRuns.getSelectionModel().select(0);

		// set current person to value of profile box
		currentPerson = new String(profile.getValue());

		// when play is pressed, check if a profile is selected,
		// if not open a window to prompt a profile name
		// else create a new instance of quick game to run game
		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (currentPerson.equals("Empty Slot")) {
					createPerson();
					fillChoiceBox();
				} else {

					if (gameType == 0) {

						QuickGame currentGame = new QuickGame(
								timeScale[timeScaleChoice.getSelectionModel().getSelectedIndex()], currentPerson,
								stopOnEvent, numRuns1, resultBOX, resultBox, currentPreset);
						currentGame.runGame();
					} else {
						new DetailedGame(timeScale[timeScaleChoice.getSelectionModel().getSelectedIndex()],
								currentPerson, numRuns1, resultBOX, resultBox, currentPreset);
					}

				}
			}

		});

		// when profile is pressed, set current person to value selected
		profile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (profile.getValue() == null) {
					currentPerson = "Empty Slot";
				} else {
					currentPerson = new String(profile.getValue());
				}
			}

		});

		// when checkbox is pressed, update value of stopOnDeath
		stopOnFired.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stopOnEvent) {
					stopOnEvent = false;
				} else {
					stopOnEvent = true;
				}
			}

		});

		// set current preset to selected preset in UI
		preset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				currentPreset = preset.getSelectionModel().getSelectedIndex();
			}

		});
		// when game selected, update to quick game or detailed game
		game.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameType = game.getSelectionModel().getSelectedIndex();
			}

		});

		// clearname button clears current profile back to empty slot
		ClearName.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				currentPerson = "Empty Slot";
				people[profile.getSelectionModel().getSelectedIndex()] = currentPerson;
				fillChoiceBox();

			}

		});
		numRuns.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				numRuns1 = numRuns.getSelectionModel().getSelectedIndex() + 1;
				
			}

		});
	}

	// new window to prompt a new profile
	public void createPerson() {
		final Pane p = new Pane();
		TextField text = new TextField();

		p.getChildren().add(text);

		Stage newStage = new Stage();
		newStage.setTitle("Create a new Profile");
		newStage.setScene(new Scene(p));
		newStage.show();

		/*
		 * https://stackoverflow.com/questions/13880638/
		 * how-do-i-pick-up-the-enter-key-being-pressed- in-javafx2
		 */
		// when enter pressed, update save file and profile list
		text.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					boolean check = false;
					for (int i = 0; i < 9 && check == false; i++) {
						if (people[i] == null || people[i].equals("Empty Slot")) {
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

	// fill profile list and update choicebox, select first in list
	public void fillChoiceBox() {

		for (int i = 0; i < 9; i++) {
			if (people[i] == null) {
				list3.add("Empty Slot");
			} else {
				list3.add(people[i]);
			}
		}
		if (list3.size() > 10) {
			list3.remove(0, 9);
		}

		profile.setItems(list3);
		profile.getSelectionModel().select(0);
	}

}

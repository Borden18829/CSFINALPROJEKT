package myPackage;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class DetailedGame extends QuickGame {

	public DetailedGame(int TimeScale, String profile, int num, VBox resultBOX, ScrollPane resultBox, int preset) {
		super(TimeScale, profile, stopOnEvent,0, resultBOX, resultBox, preset);
	}
	public DetailedGame(String profile) {
		super(profile);
	}

}

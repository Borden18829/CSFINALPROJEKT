package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class QuickGame  implements game {
	// lots of data :/
	public int timeScale;
	public int gameType;
	public static int numEvents = 0;
	public int[][] events = new int[3][11];
	public String[][] eventsName = new String[3][11];
	public String profile;
	public boolean fired = false;
	public static boolean stopOnEvent = false;
	public boolean dead = false;
	public static int deadNum = 0;
	public static String[] intervals = { "Years", "Months", "Days" };
	public static int currentEvent = 0;
	public ScrollPane resultBox;
	public VBox resultBOX;
	public static int numRuns = 1;
	public int preset;
	public int multiplier = 1;


	// Regular constructor
	public QuickGame(int timescale, String profile, boolean stopOnEvent1,
			int NumOfRuns, VBox resultBOX, ScrollPane resultBox, int preset) {
		
		this.profile = profile;
		this.timeScale = timescale;
		stopOnEvent = stopOnEvent1;
		numRuns = NumOfRuns + 1;
		this.resultBOX = resultBOX;
		this.resultBox = resultBox;
		this.preset = preset;

	}

	// Constructor in case no data is given (unlikely to happen)
	public QuickGame(String profile) {
		this.profile = profile;
		this.timeScale = 1;
	}

	// 'main' method that runs the game
	@Override
	public void runGame() {

		// scanner to read from event list file
		// store category name, size
		// store event names
		// increment number events
		try {
			Scanner file_in = new Scanner(new File("events.txt"));
			int[] categorySize = new int[3];

			for (int x = 0; x < 3; x++) {

				categorySize[x] = Integer.valueOf(file_in.nextLine()).intValue();

				eventsName[x][0] = file_in.nextLine();
				for (int y = 1; y <= categorySize[x]; y++) {
					eventsName[x][y] = file_in.nextLine();
					events[x][y] = Integer.valueOf(file_in.nextLine()).intValue();
					numEvents++;

				}

			}
			// close scanner
			file_in.close();
			
			Text text = new Text();
			text.setText("New Game with: " + profile);
			addToResultBox(text);
			
			// run main game test
		
			int currentCategory;
			int currentInterval = 10;
			int years = 0;
			int runs = 0;
			if(numRuns == 0 || numRuns == 1) {
				numRuns = 2;
			}
			// check to rerun game when game-over up to  numRuns
			while (runs != numRuns -1) {
				years = 0;
				displayToResultBox("Run: " + (runs + 1));
				//test to see if run should stop on death or on event firing
				while ((fired == false || stopOnEvent == true) && (dead == false || stopOnEvent == false)) {
					for (int interval = 0; interval < timeScale; interval++) {
						
						currentInterval = interval;
						//sets multiplier for the corresponding category
						for (int i = 0; i < 3; i++) {
							if(preset == i+ 1) {
								multiplier = 5;
							}
							else {
								multiplier = 1;
							}
							currentCategory = i;
							for (int x = 0; x < categorySize[i]; x++) {
								currentEvent = x;
								Random test = new Random();
								int testint = test.nextInt(2400000 * timeScale);
								//test the value to make sure it is valid for our test
								testint = testTheTest(testint);
								//test for event firing, if true, test if dead and display accordingly
								//adjust relevant variables as well
								if (testint <= events[i][x] * multiplier) {
									fired = true;
									test = new Random();
									testint = test.nextInt(10 * timeScale);

									if (testint >= 3 && testint <= 5) {
										dead = true;

										displayToResultBox(displayResults(years, currentInterval, currentCategory,
												currentEvent, dead));
									} else {

										displayToResultBox(displayResults(years, currentInterval, currentCategory,
												currentEvent, false));
									}

								}

							}
						}
						
						
					}
					years++;
				}
				//after each run, reset boolean variables
				fired = false;
				dead = false;
				runs++;
			}
		//when all runs are completed, display done.
			displayToResultBox("Done!");
		} catch (FileNotFoundException e) {
		}

	}

// take a string and turn into text to be passed into resultbox method
	public void displayToResultBox(String displayResults) {
		Text text = new Text();
		text.setText(displayResults);
		addToResultBox(text);
	}

	//method to take results and put them into a StringBuilder and returns to String
	@Override
	public String displayResults(int years, int interval) {
		String intervalName;
		StringBuilder msgBox = new StringBuilder();
		if (timeScale == 1) {
			msgBox.append("Year: " + years + " ,nothing!");
			return msgBox.toString();
		}
		if (timeScale == 12) {
			intervalName = " month: ";
		} else {
			intervalName = " day: ";
		}
		msgBox.append("Year: " + years + intervalName + interval + " ,nothing!");
		return msgBox.toString();

	}

	// method to display results to UI scene
	@Override
	public String displayResults(int years, int interval, int category, int event, boolean dead) {
		String intervalName;
		StringBuilder msgBox = new StringBuilder();
		if (timeScale == 1) {
			if (dead) {
				msgBox.append("Event Fired at year: " + years + ", " + "Category: " + eventsName[category][0] + ", "
						+ eventsName[category][event] + ". Rest in piece " + profile + ".");
			} else {
				msgBox.append("Event Fired at year: " + years + ", " + "Category: " + eventsName[category][0] + ", "
						+ eventsName[category][event] + ". Lucky you, " + profile + ", you survived!");
			}
			return msgBox.toString();
		}
		if (timeScale == 12) {
			intervalName = " month: ";
		} else {
			intervalName = " day: ";
		}

		if (dead == true) {
			msgBox.append("Event Fired at year: " + years + intervalName + interval + " category: "
					+ eventsName[category][0] + " " + eventsName[category][event] + ". Rest in piece " + profile);
			return msgBox.toString();
		} else {
			msgBox.append(
					"Event Fired at year:  " + years + intervalName + interval + " category: " + eventsName[category][0]
							+ " " + eventsName[category][event] + ". Lucky you, " + profile + " ,you survived!");
			return msgBox.toString();
		}

	}

	// method to display effects to UI scene
	@Override
	public void GameEffects() {

	}

	// method to make sure test values are valid
	public int testTheTest(int test1) {
		int newTest = test1;
		if (newTest > (24000000 * timeScale) - 2000000) {
			return newTest - 2000000;
		}

		return newTest;
	}
	
	//takes text and adds it to the scroll pane that was passed from the Person class
	public void addToResultBox(Text result) {
		resultBOX.getChildren().add(result);
		resultBox.setContent(resultBOX);

	}
}

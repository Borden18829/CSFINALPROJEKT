package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class QuickGame implements game {
	public int timeScale;
	public int gameType;
	public int[][] events = new int[3][];
	public String[][] eventsName = new String[3][];
	public String profile;

	public QuickGame(int timescale, String profile) {
		
	}
	public QuickGame(String profile) {
		this.profile = profile;
		this.timeScale = 1;
	}

	@Override
	public void runGame() {
		try {
			Scanner file_in = new Scanner(new File("events.txt"));
			for(int x = 0; x<3; x++) {
				int categorySize;
				categorySize = file_in.nextInt();
				String categoryName = file_in.nextLine();
				eventsName[x][0] = categoryName; 
				for(int y = 0; y<categorySize; y++) {
					eventsName[x][y] = file_in.nextLine();
					if(y > 0) {
					events[x][y] = file_in.nextInt();
					System.out.print(events[x][y]);
					}
				}
				file_in.close();
			}
				
			
		} catch (FileNotFoundException e) {
			
		}
		
	}

	@Override
	public void displayResults() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GameEffects() {
		// TODO Auto-generated method stub
		
	}

}

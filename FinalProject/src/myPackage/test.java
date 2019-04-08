package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

	public static int[][] events = new int[7][10];
	public static String[][] eventsName = new String[7][10];

	public static void main(String[] args) {
		try {
			Scanner file_in = new Scanner(new File("events.txt"));
			for (int x = 0; x < 3; x++) {
				String stringSize;
				stringSize = file_in.nextLine();
				
				String categoryName = file_in.nextLine();
				int categorySize = toInt(stringSize);
				
				eventsName[x][0] = categoryName;
				
				for (int y = 1; y < categorySize + 1; y++) {
					String eventName = file_in.nextLine();
					String prob = file_in.nextLine();
					eventsName[x][y] = eventName;
					events[x][y] = toInt(prob);
				}
				
			}
			file_in.close();
		} catch (FileNotFoundException e) {

		}
	}

	public static int toInt(String x) {
		Integer num = new Integer(x);
		return num.intValue();
	}

}

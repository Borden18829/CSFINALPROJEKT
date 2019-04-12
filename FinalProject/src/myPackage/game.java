package myPackage;
//interface to outline the basic game methods
public interface game {

	public void runGame();

	public void GameEffects();

	String displayResults(int years, int interval);

	String displayResults(int years, int interval, int category, int event, boolean dead);
}

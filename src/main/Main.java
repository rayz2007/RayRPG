package main;
import main.character.Enemy;
import main.processing.GameProgress;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			GameProgress gameProgress = new GameProgress("Ray");
			gameProgress.gameLoop();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

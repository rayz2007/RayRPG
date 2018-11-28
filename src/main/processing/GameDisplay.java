package main.processing;

import main.character.Enemy;

public class GameDisplay {
	private GameProgress gameProgress;
	
	// constructor dependency injection
	public GameDisplay(GameProgress gameProgress) {
		this.gameProgress = gameProgress;
	}
	
	public String getEnemyName(Enemy enemy) throws Exception {
		
		if (gameProgress.isEnemyExisting(enemy)) {
			return enemy.getName();
		} else {
			throw new Exception("Error! enemy not exisiting");
		}
	}
}

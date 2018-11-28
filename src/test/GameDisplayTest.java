package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import main.character.Enemy;
import main.character.Hyena;
import main.processing.GameDisplay;
import main.processing.GameProgress;

public class GameDisplayTest {
	
	// class under test
	GameDisplay gameDisplay;
	
	// dependency
	GameProgress gameProgress;
	
	// test data
	Enemy hyena;
	

	@Before
	public void setUp() throws Exception {
		hyena = new Hyena("Hyena Bot", 1);
		gameProgress = mock(GameProgress.class);
		
		// injection of fake mockito object
		gameDisplay = new GameDisplay(gameProgress);
		
	}

	@Test
	public void test_getEnemyName_isExisting() throws Exception {
		
		
		// define behavior of gameProgress (dependency) that is used in gameDisplay
		when(gameProgress.isEnemyExisting(hyena)).thenReturn(true);
		
		// execution
		String name = gameDisplay.getEnemyName(hyena);
		
		assertEquals("Hyena Bot", name);
		verify(gameProgress).isEnemyExisting(hyena);
		

	}
}

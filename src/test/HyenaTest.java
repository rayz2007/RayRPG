package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.character.Hyena;
import main.data.Item;

public class HyenaTest {
	
	double delta = 5e-10;
	
	Hyena hyena;
	String name;
	int level;

	@Before
	public void setUp() throws Exception {
		name = "Hyena Bot";
		level = 25;
		hyena = new Hyena(name, level);
	}

	@Test
	public void test_Hyena() {
		
		// attributes
		assertEquals(hyena.getName(), name);
		assertEquals(hyena.getLevel(), level);
		assertEquals(hyena.getAttack(), level * 100);
		assertEquals(hyena.getDefense(), level * 70);
		assertEquals(hyena.getHp().getMax(), level * 200);
		assertEquals(hyena.getHp().getActual_value(), level * 200);
		assertEquals(hyena.getMana().getMax(), level * 200);
		assertEquals(hyena.getMana().getActual_value(), level * 200);
		assertEquals(hyena.getXp().getMax(), level * 100);
		assertEquals(hyena.getXp().getActual_value(), 0);
		assertEquals(hyena.getStamina(), level * 60, delta);
		
		// random number item value
		int rand_item = hyena.getRandomNumItems();
		assertTrue(rand_item >= 1 && rand_item <= 10);
		
		// item list
		assertEquals(hyena.getItems().size(), 2);
		if (rand_item % 2 == 0) {
			assertEquals(hyena.getItems().get(0), Item.HP_POTION);
			assertEquals(hyena.getItems().get(1), Item.ARMOR);
		} else {
			assertEquals(hyena.getItems().get(0), Item.MANA_POTION);
			assertEquals(hyena.getItems().get(1), Item.ARMOR);
		}
	}

}

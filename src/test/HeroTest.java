package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.character.Hero;

public class HeroTest {
	
	double delta = 5e-10;
	
	Hero hero;
	String heroName;
	int heroAttack;
	int heroDefense;
	int heroHp;
	int heroMana;
	int heroXp;
	float heroStamina;
	
	@Before
	public void setUp() throws Exception {
		heroName = "Matthias";
		heroAttack = 25;
		heroDefense = 20;
		heroHp = 100;
		heroMana = 75;
		heroXp = 100;
		heroStamina = 5;
		hero = new Hero(heroName, heroAttack, heroDefense, heroHp, heroMana, heroXp, heroStamina);
	}

	@Test
	public void test_Hero() throws Exception {
		
		// hero attributes
		assertEquals(hero.getName(), heroName);
		assertEquals(hero.getAttack(), heroAttack);
		assertEquals(hero.getDefense(), heroDefense);
		assertEquals(hero.getHp().getActual_value(), heroHp);
		assertEquals(hero.getHp().getMax(), heroHp);
		assertEquals(hero.getMana().getMax(), heroMana);
		assertEquals(hero.getMana().getActual_value(), heroMana);
		assertEquals(hero.getXp().getMax(), heroXp);
		assertEquals(hero.getXp().getActual_value(), 0);	// starting xp is 0 !
		assertEquals(hero.getStamina(), heroStamina, delta);
		
		// empty item list
		assertEquals(hero.getItems().size(), 0);
	}
	
	@Test
	public void test_statusToString() {
		String toPrint = "Status Hero: " + hero.getName() + ", LVL: " + hero.getLevel() + ", ATK: " + hero.getAttack() + 
				", DEF: " + hero.getDefense() + ", HP: " + hero.getHp().getActual_value() + 
				"/" + hero.getHp().getMax() + ", MANA: " + hero.getMana().getActual_value() +
				"/" + hero.getMana().getMax() + ", XP: " + hero.getXp().getActual_value() + 
				"/" + hero.getXp().getMax() + ", Stamina: " + hero.getStamina();
		assertEquals(toPrint, hero.statusToString());
	}
	
	// TODO: test levelUp()
}

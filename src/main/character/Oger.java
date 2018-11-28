package main.character;

import main.data.Amount;
import main.data.Item;

public class Oger extends Enemy {

	public Oger(String name, int level) throws Exception {
		
		super(name, level);
		setAttack(level * 35);
		setDefense(level * 100);
		setHp(level * 500);
		setMana(level * 300);
		setXp(level * 300);
		setStamina(level * 100);
		
		if (randomNumItems % 2 == 0) {
			addItem(Item.BOOTS);
			addItem(Item.SWORD);
		} else {
			addItem(Item.HP_POTION);
			addItem(Item.SWORD);
		}
	}

}

package main.character;

import java.util.LinkedList;
import java.util.List;

import main.data.Amount;
import main.data.Item;

public abstract class Character {
	private String name;
	private int level;
	private int attack;
	private int defense;
	private Amount hp;
	private Amount mana;
	private Amount xp;	
	private float stamina;
	private List<Item> items;
	
	public Character(String name, int attack, int defense, int init_hp, int init_mana, int init_xp,
			float stamina) throws Exception {

		this.name = name;
		this.level = 1;
		setAttack(attack);
		setDefense(defense);
		setHp(init_hp);
		setMana(init_mana);
		setXp(init_xp);
		setStamina(stamina);
		this.items = new LinkedList<>();
	}
	
	public Character() throws Exception {
		super();
		// default values
		this.name = "Default name";
		this.level = 1;
		setAttack(1);
		setDefense(1);
		setHp(1);
		setMana(1);
		setXp(1);
		setStamina(1);
		this.items = new LinkedList<>();
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setLevel(int level) throws Exception {
		if (level <= 0) {
			throw new Exception("level must be > 0 !\n");
		}
		this.level = level;
	}


	public void setAttack(int attack) throws Exception {
		if (attack <= 0) {
			throw new Exception("attack must be > 0!\n");
		}
		this.attack = attack;
	}


	public void setDefense(int defense) throws Exception {
		if (defense <= 0) {
			throw new Exception("defense must be > 0!\n");
		}
		this.defense = defense;
	}


	public void setHp(int init_hp) throws Exception {
		if (init_hp <= 0) {
			throw new Exception("init_hp must be > 0!\n");
		}
		this.hp = new Amount(init_hp, init_hp);
	}


	public void setMana(int init_mana) throws Exception {
		if (init_mana <= 0) {
			throw new Exception("init_mana must be > 0!\n");
		}
		this.mana = new Amount(init_mana, init_mana);
	}


	public void setXp(int init_xp) throws Exception {
		if (init_xp <= 0) {
			throw new Exception("init_xp must be > 0!\n");
		}
		this.xp = new Amount(init_xp, 0);
	}


	// TODO: 
	public void setStamina(float stamina) throws Exception {
		if (stamina <= 0) {
			throw new Exception("stamina must be > 0!\n");
		}
		this.stamina = stamina;
	}
	
	public String getName() {
		return name;
	}


	public int getLevel() {
		return level;
	}


	public int getAttack() {
		return attack;
	}


	public int getDefense() {
		return defense;
	}


	public Amount getHp() {
		return hp;
	}


	public Amount getMana() {
		return mana;
	}


	public Amount getXp() {
		return xp;
	}


	public float getStamina() {
		return stamina;
	}
	
	
	public List<Item> getItems() {
		return items;
	}	

	
	// methods

	public void addItem(Item item) {
		this.items.add(item);		
	}
	
	public void showItems() {
		
		for (Item item : this.getItems()) {
			System.out.println(item);
		}
	}
	
	/**
	 * When a character receives new xp, update all
	 * attributes, that are in relation to that.
	 * 
	 * @param xpValue how much xp are received
	 * @throws Exception 
	 */
	public void addXp(int xpValue) throws Exception {
		if (xpValue <= 0) {
			throw new Exception("xp value cannot be <= 0 !\n");
		}
		
		while (xpValue > 0) {
			
			// check if the xpValue will cause a level up
			int diff = this.xp.getMax() - this.xp.getActual_value(); 
			
			if (xpValue >= diff) {
				levelUp();
			} else { 
				// add xp
				this.xp.setActual_value(this.xp.getActual_value() + xpValue);
			}
			
			xpValue -= diff;
		}
				
	}
	
	/**
	 * Level up a character and update the corresponding attributes.
	 * 
	 * @throws Exception 
	 * 
	 */
	public void levelUp() throws Exception {
		
		this.xp.setActual_value(0);
		this.xp.setMax((int) (this.xp.getMax() * 1.1f)); // update new xp max (+10%)
		this.setAttack((int) (this.getAttack() * 1.1f));
		this.setDefense((int) (this.getDefense() * 1.1f));
		
		// TODO: use hp, mana as resources, not just 100% / 100%
		// hp and mana should be regenerated over time, if not in battle
		this.setHp((int) (this.getHp().getMax() * 1.1f));
		this.setMana((int) (this.getMana().getMax() * 1.1f));
		
		this.setStamina(this.getStamina() * 1.1f);
		this.level++;
	}
}

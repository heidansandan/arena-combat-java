package arena.model;

public class Player extends Character{
	
	private int potions;

	public Player(String name, int maxHp, int attack, int defense) {
		super(name, maxHp, attack, defense);
		this.potions = 2; 
	}

	public int getPotions() {
		return potions;
	}
	
	public void usePotion() {
		if(potions <= 0) {
			throw new IllegalStateException("No quedan pociones.");
		}
		potions--;
		heal(10);
	}
	
	public Action chooseAction() {
		return Action.ATTACK;
	}

}

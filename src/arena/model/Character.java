package arena.model;

public abstract class Character {

	private String name;
	private int maxHp;
	private int hp;
	private int attack;
	private int defense;


	public Character(String name, int maxHp, int attack, int defense) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("name no puede ser nulo o estar vacío");
		}

		if(maxHp <= 0) {
			throw new IllegalArgumentException("maxHp tiene que se mayor que 0");
		}

		if(attack < 0) {
			throw new IllegalArgumentException("attack no puede ser negativo");
		}

		if(defense < 0) {
			throw new IllegalArgumentException("defense no puede ser negativo");
		}

		this.name = name;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.hp = maxHp;
	}


	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getHp() {
		return hp;
	}


	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}


	public boolean isAlive() {
		return hp > 0;
	}

	public void takeDamage(int rawDamage) {
		if(rawDamage < 0) {
			throw new IllegalArgumentException("El daño no puede ser negativo");
		}
		int realDamage = Math.max(1, rawDamage - defense);
		hp = Math.max(0, hp - realDamage);
	}

	public int dealDamage() {
		return attack;
	}

	protected void heal(int amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("La cantidad no puede ser 0 o negativa"); 
		}
		hp = Math.min(maxHp, hp + amount);
	}
}

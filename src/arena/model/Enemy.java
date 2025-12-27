package arena.model;

public class Enemy extends Character{
	
	private EnemyType type;

	public Enemy( EnemyType type, int maxHp, int attack, int defense) {
		super(getNameFromType(type), maxHp, attack, defense);
		
		this.type = type;
	}
	
	private static String getNameFromType(EnemyType type) {
		if(type == null) {
			throw new IllegalArgumentException("El tipo no puede ser null");
		}
		
		switch (type) {
			case GOBLIN:
				return "Goblin";
			case SKELETON:
				return "Skeleton";
			default:
				throw new IllegalStateException("Tipo desconocido" + type);
		}
	}

	public EnemyType getType() {
		return type;
	}
	
	public Action decideAction() {
		return Action.ATTACK;
	}
}

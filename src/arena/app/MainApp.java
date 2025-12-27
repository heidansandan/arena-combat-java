package arena.app;

import arena.engine.CombatEngine;
import arena.model.Enemy;
import arena.model.EnemyType;
import arena.model.Player;

public class MainApp {
	
	public static void main (String[] args) {
		Player player = new Player("Hero", 30, 8, 2);
		Enemy enemy = new Enemy(EnemyType.GOBLIN, 20, 6, 2);
		CombatEngine engine = new CombatEngine();
		engine.fight(player, enemy);
	}

}

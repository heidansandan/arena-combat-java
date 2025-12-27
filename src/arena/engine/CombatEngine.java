package arena.engine;

import arena.model.Action;
import arena.model.Enemy;
import arena.model.Player;

public class CombatEngine {
	
	public void fight(Player player, Enemy enemy) {
		while(player.isAlive() && enemy.isAlive()) {
			
			Action playerAction = player.chooseAction();
			if(playerAction == Action.ATTACK) {
				enemy.takeDamage(player.dealDamage());
			} else if (playerAction == Action.POTION) {
				player.usePotion();
			} else {
				throw new IllegalStateException("Acción del jugador no encontrada: " + playerAction);
			}
			
			if(enemy.isAlive()) {
				Action enemyAction = enemy.decideAction();
				if(enemyAction == Action.ATTACK) {
					player.takeDamage(enemy.dealDamage());
				} else {
					throw new IllegalStateException("Acción del enemigo no soportada: " + enemyAction);
				}
			}
		}
		
		if(player.isAlive()) {
			System.out.println("Victoria: " + player.getName() + " ha derrotado a " + enemy.getName());
		} else {
			System.out.println("Derrota: " + player.getName() + " ha sido derrotado por " + enemy.getName());
		}
	}

}

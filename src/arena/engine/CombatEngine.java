package arena.engine;

import java.util.Scanner;

import arena.model.Action;
import arena.model.Enemy;
import arena.model.Player;

public class CombatEngine {
	
	public void fight(Player player, Enemy enemy, Scanner sc) {
		
		int ronda = 0;
		
		System.out.println("BIENVENIDO A COMBAT ARENA");
		System.out.println("\nEmpieza el combate entre " + player.getName() + " y " + enemy.getName());
		System.out.println("\n- Hp de " + player.getName() + " " + player.getHp() + " ❤️");
		System.out.println("- Hp de " + enemy.getName() + " " + enemy.getHp() + " ❤️");
		
		while(player.isAlive() && enemy.isAlive()) {
						
			ronda += 1;
			
			System.out.println("\n  {RONDA " + ronda + "}");
			
			Action playerAction = player.chooseAction(sc);
			
			if(playerAction == Action.ATTACK) {
				
				int dmg = player.dealDamage();
				
				enemy.takeDamage(dmg);
				
				System.out.println("\n- " + player.getName() + " ataca e inflige [" + dmg + " dmg]");
				System.out.println("  " + enemy.getName() + " (" + enemy.getHp() + "/" + enemy.getMaxHp() + ") ❤️");	
			} else if (playerAction == Action.POTION) {
				
				player.usePotion();
				
				System.out.println("\n- " + player.getName() + " usa poción");
				System.out.println("  " + player.getName() + " (" + player.getHp() + "/" + player.getMaxHp() + ") ❤️");
				System.out.println("· Pociones: " + player.getPotions());
			} else {
				
				throw new IllegalStateException("**Acción del jugador no encontrada: " + playerAction + "**");
			}
			
			if(enemy.isAlive()) {
				
				Action enemyAction = enemy.decideAction();
				
				if(enemyAction == Action.ATTACK) {
					
					int dmg = enemy.dealDamage();
					
					player.takeDamage(dmg);	
					
					System.out.println("\n- " + enemy.getName() + " ataca e inflige [" + dmg + " dmg]");
					System.out.println("  " + player.getName() + " (" + player.getHp() + "/" + player.getMaxHp() + ") ❤️");	
				} else {
					
					throw new IllegalStateException("**Acción del enemigo no soportada: " + enemyAction + "**");
				}
			}
		}
		
		if(player.isAlive()) {
			
			System.out.println("\nVICTORIA: " + player.getName() + " ha derrotado a " + enemy.getName());
		} else {
			
			System.out.println("\nDERROTA: " + player.getName() + " ha sido derrotado por " + enemy.getName());
		}
	}

}

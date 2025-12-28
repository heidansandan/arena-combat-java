package arena.model;

import java.util.Scanner;

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
			throw new IllegalStateException("[No quedan pociones]");
		}
		potions--;
		heal(10);
	}

	public Action chooseAction(Scanner sc) {
		boolean seguir = true;
		while(seguir) {
			System.out.println("\n\nElige que debe realizar el " + getName());
			System.out.println("· 1) Atacar \n· 2) Poción [x" + getPotions() + "]");

			String input = sc.nextLine().trim();

			if(input.equals("1")) {
				seguir = false;
				return Action.ATTACK;
			}

			if(input.equals("2")) {
				if(potions == 0) {
					System.out.println("[No te quedan pociones]");
					continue;
				} else {
					seguir = false;
					return Action.POTION;
				}
			}

			System.out.println("**Opción no válida, elige ente (1/2)**");
		}

		throw new IllegalStateException("**No se pudo elegir una acción**");
	}

}

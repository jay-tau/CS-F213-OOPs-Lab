import java.util.Scanner;

abstract class GameCharacter {
	private String name;
	private int health;

	public GameCharacter(String name, int health) {
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return this.name;
	}

	public int getHealth() {
		return this.health;
	}

	public abstract void attack(GameCharacter target);

	public abstract void fatalAttack(GameCharacter target);

	public void takeDamange(int damage) {
		this.health -= damage;
		if (this.health < 0)
			this.health = 0;
	}
}

class Archer extends GameCharacter {
	private int numOfArrows;

	public Archer(String name) {
		super(name, 200);
		this.numOfArrows = 20;
		System.out.println("Creating an Archer named " + this.getName() + " with " + this.getHealth() + " health and "
				+ this.numOfArrows + " arrows");
	}

	public Archer(String name, int health, int numOfArrows) {
		super(name, health);
		this.numOfArrows = numOfArrows;
		System.out.println("Creating an Archer named " + this.getName() + " with " + this.getHealth() + " health and "
				+ this.numOfArrows + " arrows");
	}

	public int getNumOfArrows() {
		return numOfArrows;
	}

	@Override
	public void attack(GameCharacter target) {
		if (this.numOfArrows < 1) {
			System.out.println("Not enough arrows");
			return;
		}
		target.takeDamange(10);
		this.numOfArrows -= 1;
	}

	@Override
	public void fatalAttack(GameCharacter target) {
		if (this.numOfArrows < 5) {
			System.out.println("Not enough arrows");
			return;
		}
		target.takeDamange(40);
		this.numOfArrows -= 5;
	}
}

class Wizard extends GameCharacter {
	private int mana;

	public Wizard(String name) {
		super(name, 200);
		this.mana = 200;
		System.out.println("Creating a Wizard named " + name + " with " + 200 + " health and " + 200 + " mana");
	}

	public Wizard(String name, int health, int mana) {
		super(name, health);
		this.mana = mana;
		System.out.println("Creating a Wizard named " + name + " with " + health + " health and " + mana + " mana");
	}

	public int getMana() {
		return mana;
	}

	@Override
	public void attack(GameCharacter target) {
		if (this.mana < 25) {
			System.out.println("Not enough mana");
			return;
		}
		target.takeDamange(25);
		this.mana -= 25;
	}

	@Override
	public void fatalAttack(GameCharacter target) {
		if (this.mana < 75) {
			System.out.println("Not enough mana");
			return;
		}
		target.takeDamange(60);
		this.mana -= 75;
	}
}

public class Lab07_Q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GameCharacter[] players = new GameCharacter[2];
		for (int i = 0; i < 2; i++) {
			String type = in.next();
			if (type.equals("Archer")) {
				players[i] = new Archer(in.next(), in.nextInt(), in.nextInt());
			} else {
				players[i] = new Wizard(in.next(), in.nextInt(), in.nextInt());
			}
		}
		int numOfAttacks = in.nextInt();
		while ((players[0].getHealth() > 0 && players[1].getHealth() > 0) && numOfAttacks != 0) {
			if (in.nextInt() == 1) {
				playerAttack(players[0], players[1], in.next());
			} else {
				playerAttack(players[1], players[0], in.next());
			}
			identify(players[0]);
			identify(players[1]);
			numOfAttacks--;
		}
		if (players[0].getHealth() == 0) {
			System.out.println(players[1].getName() + " WINS");
		} else if (players[1].getHealth() == 0) {
			System.out.println(players[0].getName() + " WINS");
		} else {
			System.out.println("Both are alive");
		}
		in.close();
	}

	public static void playerAttack(GameCharacter player1, GameCharacter player2, String type) {
		if (type.equals("attack")) {
			System.out.println(player1.getName() + " attempts to attack " + player2.getName());
			player1.attack(player2);
		} else if (type.equals("fatal")) {
			System.out.println(player1.getName() + " attempts to attack heavily on " + player2.getName());
			player1.fatalAttack(player2);
		} else {
			System.out.println("Enter attack or fatal");
		}
	}

	public static void identify(GameCharacter player) {
		if (player instanceof Archer) {
			Archer a = (Archer) player;
			System.out
					.println("Name: " + a.getName() + ", Health: " + a.getHealth() + ", Arrows: " + a.getNumOfArrows());
		} else if (player instanceof Wizard) {
			Wizard w = (Wizard) player;
			System.out
					.println("Name: " + w.getName() + ", Health: " + w.getHealth() + ", Mana: " + w.getMana());
		} else {
			System.out.println("Unable to identify as Archer or Wizard");
		}
	}
}
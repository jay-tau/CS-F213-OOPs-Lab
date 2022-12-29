/*
 * We are designing a game. There are two game characters we are starting with, Archer and Wizard.
 *
 * You have to complete the abstract class, GameCharacter, by adding the following abstract methods:
 *
 * public void attack(GameCharacter target)
 * public void fatalAttack(GameCharacter target)
 * Also, implement a method in this class:
 * public void takeDamage(int damage) : Decreases the health by the input given.
 * Health cannot be negative.
 * Complete the Archer and Wizard class by extending the GameCharacter class and doing the following:
 *
 * Make two constructors for Archer. One with the parameter String name and default value for health = 200 and numofarrows = 20. Other constructor with the parameters String name, int health, int numOfArrows.
 *
 * Make similar constructors for Wizard. Put the default value for mana = 200.
 *
 * The constructors should print the following “Creating an Archer named <name> with <value> health and <value> arrows” with the respective values of health and arrows for Archer. The constructors should print the following “Creating a Wizard named <name> with <value> health and <value> mana” with the respective values of health and mana for Wizard.
 *
 * Implement the abstract methods, attack and fatalAttack as follows:
 *
 * i. Attack method for Archer does damage to the target with the value = 10 and uses 1 arrow.
 *
 * ii. FatalAttack method does damage to the target with the value = 40 and uses 5 arrows.
 *
 * If arrows are not sufficient, print “Not enough arrows”.
 *
 * Similar to be done for Wizard except:
 * i. For the attack method, put damage = 25 and use 25 mana.
 *
 * ii. For the fatalAttack method, put damage = 60 and use 75 mana.
 *
 * If mana is not sufficient, print “Not enough mana”.
 *
 * For the public class Question1, implement the following methods:
 *
 * public static void playerAttack(GameCharacter player1, GameCharacter player2, String type) : If the type is “attack”, then print “<CharacterName1> attempts to attack <CharacterName2>” and attack. If the type is “fatalAttack”, then print “<CharacterName1> attempts to attack heavily on <CharacterName2>” and do a fatal attack. Replace the tags with the input name
 * public static void identify(GameCharacter player): It should print “Name: <name>, Health: <health>, Arrows: <arrows>” for Archer and print “Name: , Health: <health>, Mana: <mana>” for Wizard.
 * Note:
 *
 * DO NOT modify any of the base code. Only add your code in the space mentioned.
 * <Tag> denotes that they have to be replaced with the respective input.
 *
 * Input format:
 *
 * The first line is either “Archer” or “Wizard” for the first character.
 * The next line is the name of the character, its health and its arrows or mana.
 * The next line is either “Archer” or “Wizard” for the second character.
 * The next line is the name of the character, its health and its arrows or mana.
 * The next line is the number of total attacks by both the characters.
 * The next lines, depending on the previous input, will be in the format 1 attack or 1 fatal or 2 attack or 2 fatal where 1 attack means that player 1 is attempting a normal attack on player 2.
 *
 * Output format:
 *
 * The first two lines are the details about the characters being created.
 *
 * For every attack, three lines are printed:
 *
 * First line is about who is attacking.
 *
 * Second line is about the current health and resources of the first player.
 *
 * Third line is about the current health and resources of the second player.
 *
 */



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
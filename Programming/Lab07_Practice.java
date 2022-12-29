/*
 * Create an abstract class “Instrument” and another abstract class ”StringedInstrument” that extends Instrument. Create a class “ElectricGuitar” that extends “StringedInstrument”.
 *
 * For Instrument class, do the following:
 * Create a private variable name of type String.
 * Create a constructor with one parameter, String name.
 * Create a getter method for the name.
 * Create an abstract method public String play()
 *
 * For StringedInstrument class, do the following:
 * Extend Instrument class
 * Create a private variable numOfStrings of type int.
 * Create a constructor with two parameters, String name and int numOfStrings.
 * Create a getter method for the numOfStrings.
 *
 * For ElectricGuitar class, do the following:
 * Extend StringedInstrument class.
 * Create two constructors, first with no parameters where the default value for name is “Anonymous Player” and numOfStrings is 0 and second with two parameters, name and numOfStrings.
 * Implement play method by returning “<name> is playing Electric Guitar”
 * Override the toString method, which returns “Electric Guitar with number of "strings=<value>”
 *
 * Input format:
 *
 * The first line is the number of guitars.
 * For every guitar, there is one line and each line has two types of format:
 *
 * i) Anon, which means that it is anonymous player
 * ii) Name numOfStrings, which means name of the player and the strings in the guitar.
 * Output format:
 *
 * For every guitar, there are two lines:
 * First line tells who is playing the guitar.
 * Second line tells how many strings are present in that guitar.
 */




import java.util.Scanner;


abstract class Instrument {
	private String name;

	public Instrument(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public abstract String play();
}

abstract class StringedInstrument extends Instrument {
	private int numOfStrings;

	public StringedInstrument(String name, int numOfStrings) {
		super(name);
		this.numOfStrings = numOfStrings;
	}

	public int getNumOfStrings() {
		return this.numOfStrings;
	}
}

class ElectricGuitar extends StringedInstrument {
	public ElectricGuitar() {
		super("Anonymous Player", 0);
	}

	public ElectricGuitar(String name, int numOfStrings) {
		super(name, numOfStrings);
	}

	public String play() {
		return this.getName() + " playing Electric Guitar";
	}

	public String toString() {
		return "Electric Guitar with number of strings=" + this.getNumOfStrings();
	}
}

public class Lab07_Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Instrument[] instruments = new Instrument[n];
        for(int i = 0; i<n; i++){
            String name = in.next();
            instruments[i] = name.equals("Anon") ? new ElectricGuitar() : new ElectricGuitar(name,in.nextInt());
        }
        for(int i = 0; i<n; i++){
            System.out.println(instruments[i].play());
            System.out.println(instruments[i]);
        }
		in.close();
    }
}
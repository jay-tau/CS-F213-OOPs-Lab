/*
 * Lab 2 - {Practice Problem}
 * Create a class Box with the following attributes:
 * Global variables: int height - the height of the box int width - the width of the box int breadth - the breadth of the box
 * Constructors: Box() - Initializes the global variables to 0 Box(int height,int width,int breadth) - Parameterized constructor to assign the height, width and breadth of a cuboid Box(int height) - Constructor that initializes the height, width and breadth of a Cube [Using this(); statement]
 * Functions: public int getVolume() - Returns the volume of the object
 * In the main function, take a character input from the user to identify the shape of the Box as follows: 'R' = Cuboid 'C' = Cube Any other character = Cuboid of height,breadth and width = 0
 * Take the respective input for the shape (height,width and breadth for a cuboid and only height for a cube), create an object of the class Box and print the volume of the Box object using the getVolume() function.
 * Topics involved : Constructor Overloading, new, Classes and objects, this keyword
 */

import java.util.*;

public class Lab02_Practice_Box {
    int height, width, breadth;

    public Lab02_Practice_Box(int height, int width, int breadth) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }

    public Lab02_Practice_Box(int side) { // Cube
        this(side, side, side);
    }

    public Lab02_Practice_Box() {
        this(0, 0, 0);
    }

    public int getVolume() {
        return (this.height * this.width * this.breadth);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        Lab02_Practice_Box b;
        if (option == 'R') {
            b = new Lab02_Practice_Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
        } else if (option == 'C') {
            b = new Lab02_Practice_Box(sc.nextInt());
        } else {
            b = new Lab02_Practice_Box();
        }
        System.out.println(b.getVolume());
        sc.close();
    }
}
